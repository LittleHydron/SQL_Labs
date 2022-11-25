package com.example.death.controller;

import com.example.death.domain.TrainerWorksIn;
import org.springframework.data.util.Pair;

import java.util.List;

public interface TrainerWorksInController extends GeneralController<TrainerWorksIn, Pair<Integer, Integer>> {
    List<Integer> findTrainerIDs(Integer gymID);
}
