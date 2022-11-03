package com.example.dto.assembler;

import com.example.controller.TrainerController;
import com.example.domain.Trainer;
import com.example.dto.TrainerDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TrainerDtoAssembler implements RepresentationModelAssembler<Trainer, TrainerDto> {
    @Override
    public TrainerDto toModel(Trainer entity) {
        Set<Integer> gymsIds = new HashSet<>(),
                setsOfExercisesIds = new HashSet<>(),
                traineesIds = new HashSet<>();
        if (entity.getSetOfExercisesById() != null) {
            entity.getSetOfExercisesById().forEach(e -> setsOfExercisesIds.add(e.getId()));
        }
        if (entity.getGyms() != null) {
            entity.getGyms().forEach(e -> gymsIds.add(e.getId()));
        }
        if (entity.getTraineesById() != null) {
            entity.getTraineesById().forEach(e -> traineesIds.add(e.getId()));
        }
        TrainerDto trainerDto = TrainerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateOfRegistration(entity.getDateOfRegistration())
                .salaryInDollars(entity.getSalaryInDollars())
                .gymsIds(gymsIds)
                .traineesIds(traineesIds)
                .setsOfExercisesIds(setsOfExercisesIds)
                .build();
        Link selfLink = linkTo(methodOn(TrainerController.class).getTrainer(trainerDto.getId())).withSelfRel();
        trainerDto.add(selfLink);
        return trainerDto;
    }

    @Override
    public CollectionModel<TrainerDto> toCollectionModel(Iterable<? extends Trainer> entities){
        CollectionModel<TrainerDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(TrainerController.class).getAllTrainers()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
