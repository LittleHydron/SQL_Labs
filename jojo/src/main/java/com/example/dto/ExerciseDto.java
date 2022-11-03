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
@Relation(itemRelation = "exercise", collectionRelation = "exercises")
public class ExerciseDto extends RepresentationModel<ExerciseDto> {
    @Setter
    private Integer id;
    private final String name;
    private final Integer numberOfReps;
    private final Double distanceInMeters;
    private final Integer durationInMin;
    private final Set<Integer> programsIds;
}
