package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Gym {
    private Integer ID;
    private String name;
    private String adress;
    private Date date_of_creation;
}
