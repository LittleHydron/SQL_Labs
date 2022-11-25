package com.example.controller;

import com.example.domain.Exercise;
import com.example.domain.SetOfExercises;
import com.example.domain.Program;
import com.example.dto.ProgramContainsDto;
import com.example.dto.ProgramDto;
import com.example.dto.assembler.ProgramDtoAssembler;
import com.example.service.ExerciseService;
import com.example.service.SetOfExercisesService;
import com.example.service.ProgramService;
import com.example.service.TrainerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/programs")
public class ProgramController {
    @Autowired
    private final ProgramService programService;
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final ExerciseService exerciseService;
    @Autowired
    private final SetOfExercisesService setOfExercisesService;
    @Autowired
    private final ProgramDtoAssembler programDtoAssembler;
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @PostMapping(value = "")
    public ResponseEntity<ProgramDto> addProgram(@RequestBody ProgramDto programDto) {
        Program program = new Program();
        program.setDificultyLevel(programDto.getDifficultyLevel());
        program.setName(programDto.getName());
        Set<Exercise> exercises = new HashSet<>();
        programDto.getExercisesIds().forEach(id -> exercises.add(exerciseService.findById(id)));
        program.setExercises(exercises);
        Set<SetOfExercises> sets = new HashSet<>();
        programDto.getSetsOfExercisesIds().forEach(id -> sets.add(setOfExercisesService.findById(id)));
        program.setSetsOfExcercisesById(sets);
        program = programService.create(program);
        programDto = programDtoAssembler.toModel(program);
        return new ResponseEntity<>(programDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{programId}")
    public ResponseEntity<?> updateProgram(@RequestBody ProgramDto programDto, @PathVariable Integer programId) {
        Program program = new Program();
        program.setDificultyLevel(programDto.getDifficultyLevel());
        program.setName(programDto.getName());
        Set<Exercise> exercises = new HashSet<>();
        programDto.getExercisesIds().forEach(id -> exercises.add(exerciseService.findById(id)));
        program.setExercises(exercises);
        Set<SetOfExercises> sets = new HashSet<>();
        programDto.getSetsOfExercisesIds().forEach(id -> sets.add(setOfExercisesService.findById(id)));
        program.setSetsOfExcercisesById(sets);
        programService.update(programId, program);
        return new ResponseEntity<>(programDto, HttpStatus.OK);
    }

    @PutMapping(value="/addExercise")
    public ResponseEntity<?> addExerciseToProgram(@RequestBody ProgramContainsDto programContainsDto){
        jdbcTemplate.update("INSERT program_contains(program_id, exercise_id) VALUES(?, ?)",
                programContainsDto.getProgramId(), programContainsDto.getExerciseId());
        return new ResponseEntity<>(programDtoAssembler.toModel(programService.findById(programContainsDto.getProgramId())), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{programId}")
    public ResponseEntity<?> deleteProgram(@PathVariable Integer programId) {
        programService.delete(programId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{programId}")
    public ResponseEntity<ProgramDto> getProgram(@PathVariable Integer programId) {
        Program program = programService.findById(programId);
        ProgramDto programDto = programDtoAssembler.toModel(program);
        return new ResponseEntity<>(programDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ProgramDto>> getAllPrograms() {
        List<Program> programs = programService.findAll();
        CollectionModel<ProgramDto> programsDtos = programDtoAssembler.toCollectionModel(programs);
        return new ResponseEntity<>(programsDtos, HttpStatus.OK);
    }
}

