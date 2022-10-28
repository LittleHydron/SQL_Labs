package com.example.death.service.impl;

import com.example.death.dao.TrainerWorksInDao;
import com.example.death.domain.TrainerWorksIn;
import com.example.death.service.TrainerWorksInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerWorksInServiceImpl implements TrainerWorksInService {

    @Autowired
    private TrainerWorksInDao dao;

    @Override
    public List<TrainerWorksIn> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<TrainerWorksIn> findById(Pair<Integer, Integer> integerIntegerPair) {
        return dao.findById(integerIntegerPair);
    }

    @Override
    public int create(TrainerWorksIn entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Pair<Integer, Integer> integerIntegerPair, TrainerWorksIn entity) {
        return dao.update(integerIntegerPair, entity);
    }

    @Override
    public int delete(Pair<Integer, Integer> integerIntegerPair) {
        return dao.delete(integerIntegerPair);
    }

    @Override
    public List<Integer> findTrainerIDs(Integer gymID) {
        return dao.findTrainerIDs(gymID);
    }
}
