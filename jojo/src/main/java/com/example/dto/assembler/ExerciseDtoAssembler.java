package com.example.dto.assembler;

import com.example.controller.ExerciseController;
import com.example.domain.Exercise;
import com.example.dto.ExerciseDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ExerciseDtoAssembler implements RepresentationModelAssembler<Exercise, ExerciseDto> {
    @Override
    public ExerciseDto toModel(Exercise entity) {
        Set<Integer> programsId = new HashSet<>();
        if (entity.getPrograms() != null){
            entity.getPrograms().forEach(e->programsId.add(e.getId()));
        }
        ExerciseDto exerciseDto = ExerciseDto.builder()
                .id(entity.getId())
                .distanceInMeters(entity.getDistanceInMeters())
                .name(entity.getName())
                .numberOfReps(entity.getNumberOfReps())
                .durationInMin(entity.getDurationInMin())
                .programsIds(programsId)
                .build();
        Link selfLink = linkTo(methodOn(ExerciseController.class).getExercise(exerciseDto.getId())).withSelfRel();
        exerciseDto.add(selfLink);
        return exerciseDto;
    }

    @Override
    public CollectionModel<ExerciseDto> toCollectionModel(Iterable<? extends Exercise> entities){
        CollectionModel<ExerciseDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ExerciseController.class).getAllExercises()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
