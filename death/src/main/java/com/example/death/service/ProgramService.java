package com.example.death.service;

import com.example.death.domain.Program;

import java.util.List;

public interface ProgramService extends GeneralService<Program, Integer> {
    List<Program> findByProgramDifficulty(Integer level);
}