package com.example.death.controller.impl;

import com.example.death.controller.TrainerWorksInController;
import com.example.death.domain.TrainerWorksIn;
import com.example.death.service.TrainerWorksInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerWorksInControllerImpl implements TrainerWorksInController {

    @Autowired
    private TrainerWorksInService service;

    @Override
    public List<TrainerWorksIn> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<TrainerWorksIn> findById(Pair<Integer, Integer> integerIntegerPair) {
        return service.findById(integerIntegerPair);
    }

    @Override
    public int create(TrainerWorksIn entity) {
        return service.create(entity);
    }

    @Override
    public int update(Pair<Integer, Integer> integerIntegerPair, TrainerWorksIn entity) {
        return service.update(integerIntegerPair, entity);
    }

    @Override
    public int delete(Pair<Integer, Integer> integerIntegerPair) {
        return service.delete(integerIntegerPair);
    }

    @Override
    public List<Integer> findTrainerIDs(Integer gymID) {
        return service.findTrainerIDs(gymID);
    }
}
