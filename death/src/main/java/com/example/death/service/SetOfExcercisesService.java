package com.example.death.service;

import com.example.death.domain.SetOfExcercises;

import java.util.List;

public interface SetOfExcercisesService extends GeneralService<SetOfExcercises, Integer> {
    List<SetOfExcercises> findByTrainerID(Integer trainer_ID);
}