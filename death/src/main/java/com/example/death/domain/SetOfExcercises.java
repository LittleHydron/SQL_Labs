package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetOfExcercises {
    private Integer ID;
    private Integer Program_ID;
    private Integer Trainer_ID;
    private Integer Trainee_ID;
    private Date Date_of_start;
    private Date Date_of_end;
}
