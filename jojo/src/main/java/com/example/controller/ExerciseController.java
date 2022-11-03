package com.example.controller;

import com.example.domain.Program;
import com.example.domain.Exercise;
import com.example.dto.ExerciseDto;
import com.example.dto.assembler.ExerciseDtoAssembler;
import com.example.service.ProgramService;
import com.example.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value = "/api/exercises")
public class ExerciseController {
    @Autowired
    private final ExerciseService exerciseService;
    @Autowired
    private final ProgramService programService;
    @Autowired
    private final ExerciseDtoAssembler exerciseDtoAssembler;

    @PostMapping(value = "")
    public ResponseEntity<ExerciseDto> addExercise(@RequestBody ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise();
        exercise.setDistanceInMeters(exerciseDto.getDistanceInMeters());
        exercise.setDurationInMin(exerciseDto.getDurationInMin());
        exercise.setNumberOfReps(exerciseDto.getNumberOfReps());
        exercise.setName(exerciseDto.getName());
        exercise.setId(exerciseDto.getId());
        Set<Program> set = new HashSet<>();
        exerciseDto.getProgramsIds().forEach(id -> set.add(programService.findById(id)));
        exercise.setPrograms(set);
        exercise = exerciseService.create(exercise);
        exerciseDto = exerciseDtoAssembler.toModel(exercise);
        return new ResponseEntity<>(exerciseDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{exerciseId}")
    public ResponseEntity<?> updateExercise(@RequestBody ExerciseDto exerciseDto, @PathVariable Integer exerciseId) {
        Exercise exercise = new Exercise();
        exercise.setDistanceInMeters(exerciseDto.getDistanceInMeters());
        exercise.setDurationInMin(exerciseDto.getDurationInMin());
        exercise.setNumberOfReps(exerciseDto.getNumberOfReps());
        exercise.setName(exerciseDto.getName());
        exercise.setId(exerciseDto.getId());
        Set<Program> set = new HashSet<>();
        exerciseDto.getProgramsIds().forEach(id -> set.add(programService.findById(id)));
        exercise.setPrograms(set);
        exerciseService.update(exerciseId, exercise);
        return new ResponseEntity<>(exerciseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{exerciseId}")
    public ResponseEntity<?> deleteExercise(@PathVariable Integer exerciseId) {
        exerciseService.delete(exerciseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{exerciseId}")
    public ResponseEntity<ExerciseDto> getExercise(@PathVariable Integer exerciseId) {
        Exercise exercise = exerciseService.findById(exerciseId);
        ExerciseDto exerciseDto = exerciseDtoAssembler.toModel(exercise);
        return new ResponseEntity<>(exerciseDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ExerciseDto>> getAllExercises() {
        List<Exercise> exercises = exerciseService.findAll();
        CollectionModel<ExerciseDto> exercisesDtos = exerciseDtoAssembler.toCollectionModel(exercises);
        return new ResponseEntity<>(exercisesDtos, HttpStatus.OK);
    }
}

