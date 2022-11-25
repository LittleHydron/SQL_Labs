package com.example.dto.assembler;

import com.example.controller.GymController;
import com.example.domain.Gym;
import com.example.domain.Trainer;
import com.example.dto.GymDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GymDtoAssembler implements RepresentationModelAssembler<Gym, GymDto> {
    @Override
    public GymDto toModel(Gym entity) {
        Set<Integer> trainersIds = new HashSet<>();
        if (entity.getTrainers() != null){
            entity.getTrainers().forEach(trainer->trainersIds.add(trainer.getId()));
        }
        GymDto gymDto = GymDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .dateOfCreation(entity.getDateOfCreation())
                .address(entity.getAddress())
                .trainersIds(trainersIds)
                .build();
        Link selfLink = linkTo(methodOn(GymController.class).getGym(gymDto.getId())).withSelfRel();
        gymDto.add(selfLink);
        return gymDto;
    }

    @Override
    public CollectionModel<GymDto> toCollectionModel(Iterable<? extends Gym> entities){
        CollectionModel<GymDto> exerciseDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(GymController.class).getAllGyms()).withSelfRel();
        exerciseDtos.add(selfLink);
        return exerciseDtos;
    }
}
