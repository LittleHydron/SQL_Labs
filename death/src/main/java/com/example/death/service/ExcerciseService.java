package com.example.death.service;

import com.example.death.domain.Excercise;
import com.example.death.domain.ProgramContains;
import org.springframework.data.util.Pair;

import java.util.Optional;

public interface ExcerciseService extends GeneralService<Excercise, Integer> {
    Optional<Excercise> findByExcerciseName(String name);

    interface ProgramContainsService extends GeneralService<ProgramContains, Pair<Integer, Integer>> {

    }
}