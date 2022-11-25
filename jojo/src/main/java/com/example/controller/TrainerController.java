package com.example.controller;

import com.example.domain.Trainer;
import com.example.dto.TrainerDto;
import com.example.dto.assembler.TrainerDtoAssembler;
import com.example.service.GymService;
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
@RequestMapping(value = "/api/trainers")
public class TrainerController {
    @Autowired
    private final TrainerDtoAssembler trainerDtoAssembler;
    @Autowired
    private final TrainerService trainerService;
    @Autowired
    private final TraineeService traineeService;
    @Autowired
    private final GymService gymService;
    @Autowired
    private final SetOfExercisesService setOfExercisesService;

    @PostMapping(value = "")
    public ResponseEntity<TrainerDto> addTrainer(@RequestBody TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        trainer.setSalaryInDollars(trainerDto.getSalaryInDollars());
        trainer.setName(trainerDto.getName());
        trainer.setDateOfRegistration(trainerDto.getDateOfRegistration());
        trainer = trainerService.create(trainer);
        trainerDto = trainerDtoAssembler.toModel(trainer);
        return new ResponseEntity<>(trainerDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{trainerId}")
    public ResponseEntity<?> updateTrainer(@RequestBody TrainerDto trainerDto, @PathVariable Integer trainerId) {
        System.out.println(trainerDto.getDateOfRegistration());
        Trainer trainer = new Trainer();
        trainer.setSalaryInDollars(trainerDto.getSalaryInDollars());
        trainer.setName(trainerDto.getName());
        trainer.setDateOfRegistration(trainerDto.getDateOfRegistration());
        trainerService.update(trainerId, trainer);
        return new ResponseEntity<>(trainerDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{trainerId}")
    public ResponseEntity<?> deleteTrainer(@PathVariable Integer trainerId) {
        trainerService.delete(trainerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{trainerId}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Integer trainerId) {
        return new ResponseEntity<>(trainerDtoAssembler.toModel(trainerService.findById(trainerId)), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<TrainerDto>> getAllTrainers() {
        return new ResponseEntity<>(trainerDtoAssembler.toCollectionModel(trainerService.findAll()), HttpStatus.OK);
    }
}
