package com.example.death.service;

import com.example.death.domain.ProgramContains;
import org.springframework.data.util.Pair;

import java.util.List;

public interface ProgramContainsService extends GeneralService<ProgramContains, Pair<Integer, Integer>>{
    List<Integer> findExcerciseIDs(Integer programID);
}
