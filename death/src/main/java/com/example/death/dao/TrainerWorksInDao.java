package com.example.death.dao;

import com.example.death.domain.TrainerWorksIn;
import org.springframework.data.util.Pair;

import java.util.List;

public interface TrainerWorksInDao extends GeneralDao<TrainerWorksIn, Pair<Integer, Integer>> {
    List<Integer> findTrainerIDs(Integer gymID);
}
