package com.example.death.controller.impl;

import com.example.death.controller.ProgramContainsController;
import com.example.death.domain.ProgramContains;
import com.example.death.service.ProgramContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramContainsControllerImpl implements ProgramContainsController {

    @Autowired
    private ProgramContainsService service;

    @Override
    public List<ProgramContains> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<ProgramContains> findById(Pair<Integer, Integer> integerIntegerPair) {
        return service.findById(integerIntegerPair);
    }

    @Override
    public int create(ProgramContains entity) {
        return service.create(entity);
    }

    @Override
    public int update(Pair<Integer, Integer> integerIntegerPair, ProgramContains entity) {
        return service.update(integerIntegerPair, entity);
    }

    @Override
    public int delete(Pair<Integer, Integer> integerIntegerPair) {
        return service.delete(integerIntegerPair);
    }

    @Override
    public List<Integer> findExcerciseIDs(Integer programID) {
        return service.findExcerciseIDs(programID);
    }
}
