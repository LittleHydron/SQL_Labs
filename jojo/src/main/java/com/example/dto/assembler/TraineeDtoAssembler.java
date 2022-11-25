package com.example.dto.assembler;

import com.example.controller.TraineeController;
import com.example.domain.Trainee;
import com.example.dto.TraineeDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TraineeDtoAssembler implements RepresentationModelAssembler<Trainee, TraineeDto> {
    @Override
    public TraineeDto toModel(Trainee entity) {
        Set<Integer> set = new HashSet<>();
        if (entity.getSetsOfExcercisesById() != null) {
            entity.getSetsOfExcercisesById().forEach(s -> set.add(s.getId()));
        }
        TraineeDto traineeDto = TraineeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateOfRegistration(entity.getDateOfRegistration())
                .telephoneNumber(entity.getTelephoneNumber())
                .trainerId(entity.getTrainer().getId())
                .setsOfExercisesIds(set)
                .build();
        Link selfLink = linkTo(methodOn(TraineeController.class).getTrainee(traineeDto.getId())).withSelfRel();
        traineeDto.add(selfLink);
        return traineeDto;
    }

    @Override
    public CollectionModel<TraineeDto> toCollectionModel(Iterable<? extends Trainee> entities){
        CollectionModel<TraineeDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(TraineeController.class).getAllTrainees()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
