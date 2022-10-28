package com.example.death.controller.impl;

import com.example.death.controller.ProgramController;
import com.example.death.domain.Program;
import com.example.death.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramControllerImpl implements ProgramController {

    @Autowired
    private ProgramService service;

    @Override
    public List<Program> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Program> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(Program entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, Program entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }

    @Override
    public List<Program> findByProgramDifficulty(Integer level) {
        return service.findByProgramDifficulty(level);
    }
}
