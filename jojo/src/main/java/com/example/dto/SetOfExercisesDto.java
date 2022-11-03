package com.example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.sql.Date;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "setOfExercises", collectionRelation = "setsOfExercises")
public class SetOfExercisesDto extends RepresentationModel<SetOfExercisesDto> {
    @Setter
    private Integer id;
    private Integer programId;
    private Integer trainerId;
    private Integer traineeId;
    private Date dateOfStart;
    private Date dateOfEnd;
}
