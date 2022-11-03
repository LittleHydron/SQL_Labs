package com.example.dto.assembler;

import com.example.controller.ProgramController;
import com.example.domain.Program;
import com.example.dto.ProgramDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProgramDtoAssembler implements RepresentationModelAssembler<Program, ProgramDto> {
    @Override
    public ProgramDto toModel(Program entity) {
        Set<Integer> setsOfEx = new HashSet<>();
        if (entity.getSetsOfExcercisesById() != null){
            entity.getSetsOfExcercisesById().forEach(e->setsOfEx.add(e.getId()));
        }
        Set<Integer> setOfEx = new HashSet<>();
        if (entity.getExercises() != null){
            entity.getExercises().forEach(e->setOfEx.add(e.getId()));
        }
        ProgramDto programDto = ProgramDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .difficultyLevel(entity.getDifficultyLevel())
                .exercisesIds(setOfEx)
                .setsOfExercisesIds(setsOfEx)
                .build();
        Link selfLink = linkTo(methodOn(ProgramController.class).getProgram(programDto.getId())).withSelfRel();
        programDto.add(selfLink);
        return programDto;
    }

    @Override
    public CollectionModel<ProgramDto> toCollectionModel(Iterable<? extends Program> entities){
        CollectionModel<ProgramDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ProgramController.class).getAllPrograms()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
