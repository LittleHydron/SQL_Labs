package com.example.death.controller;

import com.example.death.domain.Trainee;

import java.util.List;

public interface TraineeController extends GeneralController<Trainee, Integer> {
    List<Trainee> findByName(String name);
}