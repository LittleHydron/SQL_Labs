package com.example.death.dao;

import com.example.death.domain.Excercise;

import java.util.Optional;

public interface ExcerciseDao extends GeneralDao<Excercise, Integer> {
    Optional<Excercise> findByExcerciseName(String name);
}