package com.example.controller;

import com.example.domain.SetOfExercises;
import com.example.dto.SetOfExercisesDto;
import com.example.dto.assembler.SetOfExercisesDtoAssembler;
import com.example.service.ProgramService;
import com.example.service.SetOfExercisesService;
import com.example.service.TraineeService;
import com.example.service.TrainerService;
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

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/setsOfExercises")
public class SetOfExercisesController {
    @Autowired
    private final SetOfExercisesService setOfExercisesService;
    @Autowired
    private final SetOfExercisesDtoAssembler setOfExercisesDtoAssembler;
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final TraineeService traineeService;
    @Autowired
    private final ProgramService programService;

    @PostMapping(value = "")
    public ResponseEntity<SetOfExercisesDto> addSetOfExcercises(@RequestBody SetOfExercisesDto setOfExercisesDto) {
        SetOfExercises setOfExercises = new SetOfExercises();
        setOfExercises.setDateOfEnd(setOfExercisesDto.getDateOfEnd());
        setOfExercises.setDateOfStart(setOfExercisesDto.getDateOfStart());
        setOfExercises.setTrainerByTrainerId(trainerService.findById(setOfExercisesDto.getTrainerId()));
        setOfExercises.setProgramByProgramId(programService.findById(setOfExercisesDto.getProgramId()));
        setOfExercises.setTraineeByTraineeId(traineeService.findById(setOfExercisesDto.getTraineeId()));
        setOfExercises = setOfExercisesService.create(setOfExercises);
        setOfExercisesDto = setOfExercisesDtoAssembler.toModel(setOfExercises);
        return new ResponseEntity<>(setOfExercisesDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{setOfExercisesId}")
    public ResponseEntity<?> updateSetOfExcercises(@RequestBody SetOfExercisesDto setOfExercisesDto, @PathVariable Integer setOfExercisesId) {
        SetOfExercises setOfExercises = new SetOfExercises();
        setOfExercises.setDateOfEnd(setOfExercisesDto.getDateOfEnd());
        setOfExercises.setDateOfStart(setOfExercisesDto.getDateOfStart());
        setOfExercises.setTrainerByTrainerId(trainerService.findById(setOfExercisesDto.getTrainerId()));
        setOfExercises.setProgramByProgramId(programService.findById(setOfExercisesDto.getProgramId()));
        setOfExercises.setTraineeByTraineeId(traineeService.findById(setOfExercisesDto.getTraineeId()));
        setOfExercisesService.update(setOfExercisesId, setOfExercises);
        return new ResponseEntity<>(setOfExercisesDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{setOfExcercisesId}")
    public ResponseEntity<?> deleteSetOfExcercises(@PathVariable Integer setOfExcercisesId) {
        setOfExercisesService.delete(setOfExcercisesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{setOfExcercisesId}")
    public ResponseEntity<SetOfExercisesDto> getSetOfExcercises(@PathVariable Integer setOfExcercisesId) {
        return new ResponseEntity<>(setOfExercisesDtoAssembler.toModel(setOfExercisesService.findById(setOfExcercisesId)), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SetOfExercisesDto>> getAllSetsOfExcercises() {
        return new ResponseEntity<>(setOfExercisesDtoAssembler.toCollectionModel(setOfExercisesService.findAll()), HttpStatus.OK);
    }
}

