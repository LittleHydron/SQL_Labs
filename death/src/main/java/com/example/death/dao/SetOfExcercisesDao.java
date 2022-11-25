package com.example.death.dao;

import com.example.death.domain.SetOfExcercises;

import java.util.List;

public interface SetOfExcercisesDao extends GeneralDao<SetOfExcercises, Integer> {
    List<SetOfExcercises> findByTrainerID(Integer trainer_ID);
}