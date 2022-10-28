package com.example.death.dao;

import com.example.death.domain.Excercise;
import com.example.death.domain.Program;

import java.util.List;

public interface ProgramDao extends GeneralDao<Program, Integer> {
    List<Program> findByProgramDifficulty(Integer level);
}