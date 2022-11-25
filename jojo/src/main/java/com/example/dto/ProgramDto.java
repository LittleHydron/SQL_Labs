package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Set;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "program", collectionRelation = "programs")
public class ProgramDto extends RepresentationModel<ProgramDto> {
    @Setter
    private Integer id;
    private final String name;
    private final Integer difficultyLevel;
    private final Set<Integer> exercisesIds;
    private final Set<Integer> setsOfExercisesIds;
}
