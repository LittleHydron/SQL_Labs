package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Trainer {
    private Integer ID;
    private String Name;
    private Date Date_of_registration;
    private Double Salary_in_dollars;
}
