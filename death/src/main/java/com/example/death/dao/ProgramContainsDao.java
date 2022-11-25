package com.example.death.dao;

import com.example.death.domain.ProgramContains;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ProgramContainsDao extends GeneralDao<ProgramContains, Pair<Integer, Integer>> {
    List<Integer> findExcerciseIDs(Integer programID);
}
