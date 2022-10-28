package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainerWorksIn {
    private Integer trainer_ID;
    private Integer gym_ID;
}
