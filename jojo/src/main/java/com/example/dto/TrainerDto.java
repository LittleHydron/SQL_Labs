package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Date;
import java.util.Set;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "trainer", collectionRelation = "trainers")
public class TrainerDto extends RepresentationModel<TrainerDto> {
    @Setter
    private Integer id;
    private String name;
    private Date dateOfRegistration;
    private Double salaryInDollars;
    private Set<Integer> gymsIds;
    private Set<Integer> setsOfExercisesIds;
    private Set<Integer> traineesIds;
}
