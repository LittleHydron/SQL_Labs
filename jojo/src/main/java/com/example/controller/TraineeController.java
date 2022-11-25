package com.example.controller;

import com.example.domain.SetOfExercises;
import com.example.domain.Trainee;
import com.example.dto.TraineeDto;
import com.example.dto.assembler.TraineeDtoAssembler;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/trainees")
public class TraineeController {
    @Autowired
    private final TraineeService traineeService;
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final TraineeDtoAssembler traineeDtoAssembler;

    @PostMapping(value = "")
    public ResponseEntity<TraineeDto> addTrainee(@RequestBody TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setTrainer(trainerService.findById(traineeDto.getTrainerId()));
        trainee.setDateOfRegistration(traineeDto.getDateOfRegistration());
        trainee.setTelephoneNumber(traineeDto.getTelephoneNumber());
        trainee.setName(traineeDto.getName());
        trainee.setId(traineeDto.getId());
        trainee = traineeService.create(trainee);
        traineeDto = traineeDtoAssembler.toModel(trainee);
        return new ResponseEntity<>(traineeDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{traineeId}")
    public ResponseEntity<?> updateTrainee(@RequestBody TraineeDto traineeDto, @PathVariable Integer traineeId) {
        Trainee trainee = new Trainee();
        trainee.setTrainer(trainerService.findById(traineeDto.getTrainerId()));
        trainee.setDateOfRegistration(traineeDto.getDateOfRegistration());
        trainee.setTelephoneNumber(traineeDto.getTelephoneNumber());
        trainee.setName(traineeDto.getName());
        trainee.setId(traineeDto.getId());
        traineeService.update(traineeId, trainee);
        return new ResponseEntity<>(traineeDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{traineeId}")
    public ResponseEntity<?> deleteTrainee(@PathVariable Integer traineeId) {
        traineeService.delete(traineeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{traineeId}")
    public ResponseEntity<TraineeDto> getTrainee(@PathVariable Integer traineeId) {
        Trainee trainee = traineeService.findById(traineeId);
        TraineeDto traineeDto = traineeDtoAssembler.toModel(trainee);
        return new ResponseEntity<>(traineeDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<TraineeDto>> getAllTrainees() {
        List<Trainee> trainees = traineeService.findAll();
        CollectionModel<TraineeDto> traineesDtos = traineeDtoAssembler.toCollectionModel(trainees);
        return new ResponseEntity<>(traineesDtos, HttpStatus.OK);
    }
}

