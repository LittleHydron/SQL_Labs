package com.example.dto.assembler;

import com.example.controller.SetOfExercisesController;
import com.example.domain.SetOfExercises;
import com.example.dto.SetOfExercisesDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SetOfExercisesDtoAssembler implements RepresentationModelAssembler<SetOfExercises, SetOfExercisesDto> {
    @Override
    public SetOfExercisesDto toModel(SetOfExercises entity) {
        SetOfExercisesDto setOfExercisesDto = SetOfExercisesDto.builder()
                .id(entity.getId())
                .programId(entity.getProgramByProgramId().getId())
                .trainerId(entity.getTrainerByTrainerId().getId())
                .traineeId(entity.getTraineeByTraineeId().getId())
                .dateOfEnd(entity.getDateOfEnd())
                .dateOfStart(entity.getDateOfStart())
                .build();
        Link selfLink = linkTo(methodOn(SetOfExercisesController.class).getSetOfExcercises(setOfExercisesDto.getId())).withSelfRel();
        setOfExercisesDto.add(selfLink);
        return setOfExercisesDto;
    }

    @Override
    public CollectionModel<SetOfExercisesDto> toCollectionModel(Iterable<? extends SetOfExercises> entities){
        CollectionModel<SetOfExercisesDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SetOfExercisesController.class).getAllSetsOfExcercises()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
