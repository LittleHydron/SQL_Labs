package com.example.death.controller;

import com.example.death.domain.Program;

import java.util.List;

public interface ProgramController extends GeneralController<Program, Integer> {
    List<Program> findByProgramDifficulty(Integer level);
}