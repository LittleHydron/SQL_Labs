package com.example.death.controller;

import com.example.death.domain.Excercise;

import java.util.Optional;

public interface ExcerciseController extends GeneralController<Excercise, Integer> {
    Optional<Excercise> findByExcerciseName(String name);
}