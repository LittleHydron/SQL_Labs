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
@Relation(itemRelation = "gym", collectionRelation = "gyms")
public class GymDto extends RepresentationModel<GymDto> {
    @Setter
    private Integer id;
    private final String name;
    private final Date dateOfCreation;
    private final String address;
    private final Set<Integer> trainersIds;
}
