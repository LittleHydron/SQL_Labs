package com.example.death.service;

import com.example.death.domain.Trainee;

import java.util.List;

public interface TraineeService extends GeneralService<Trainee, Integer> {
    List<Trainee> findByName(String name);
}