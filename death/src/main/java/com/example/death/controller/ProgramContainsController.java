package com.example.death.controller;

import com.example.death.domain.ProgramContains;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ProgramContainsController extends GeneralController<ProgramContains, Pair<Integer, Integer>> {
    List<Integer> findExcerciseIDs(Integer programID);
}
