package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Excercise {
    private Integer ID;
    private String Name;
    private Integer Number_of_reps;
    private Integer Distance_in_meters;
    private Integer Duration_in_min;
}
