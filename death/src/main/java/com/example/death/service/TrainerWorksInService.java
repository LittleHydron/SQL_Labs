package com.example.death.service;

import com.example.death.domain.TrainerWorksIn;
import org.springframework.data.util.Pair;

import java.util.List;

public interface TrainerWorksInService extends GeneralService<TrainerWorksIn, Pair<Integer, Integer>>{
    List<Integer> findTrainerIDs(Integer gymID);
}
