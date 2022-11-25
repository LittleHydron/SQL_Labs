package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainee {
    private Integer ID;
    private String Name;
    private Date Date_of_registration;
    private String Telephone_number;
    private Integer Trainer_ID;
}
