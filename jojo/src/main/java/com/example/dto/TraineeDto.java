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
@Relation(itemRelation = "trainee", collectionRelation = "trainees")
public class TraineeDto extends RepresentationModel<TraineeDto> {
    @Setter
    private Integer id;
    private String name;
    private Date dateOfRegistration;
    private String telephoneNumber;
    private Integer trainerId;
    private Set<Integer> setsOfExercisesIds;
}
