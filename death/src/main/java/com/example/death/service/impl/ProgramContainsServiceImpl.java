package com.example.death.service.impl;

import com.example.death.dao.ProgramContainsDao;
import com.example.death.domain.ProgramContains;
import com.example.death.service.ProgramContainsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramContainsServiceImpl implements ProgramContainsService {

    @Autowired
    private ProgramContainsDao dao;

    @Override
    public List<ProgramContains> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<ProgramContains> findById(Pair<Integer, Integer> integerIntegerPair) {
        return dao.findById(integerIntegerPair);
    }

    @Override
    public int create(ProgramContains entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Pair<Integer, Integer> integerIntegerPair, ProgramContains entity) {
        return dao.update(integerIntegerPair, entity);
    }

    @Override
    public int delete(Pair<Integer, Integer> integerIntegerPair) {
        return dao.delete(integerIntegerPair);
    }

    @Override
    public List<Integer> findExcerciseIDs(Integer programID) {
        return dao.findExcerciseIDs(programID);
    }
}
