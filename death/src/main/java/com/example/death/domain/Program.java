package com.example.death.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Program {
    private Integer ID;
    private String Name;
    private Integer Dificulty_level;
}
