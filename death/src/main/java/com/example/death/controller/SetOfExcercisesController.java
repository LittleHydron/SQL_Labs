package com.example.death.controller;

import com.example.death.domain.SetOfExcercises;

import java.util.List;

public interface SetOfExcercisesController extends GeneralController<SetOfExcercises, Integer> {
    List<SetOfExcercises> findByTrainerID(Integer trainer_ID);
}