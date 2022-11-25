package com.example.death.service.impl;

import com.example.death.dao.ExcerciseDao;
import com.example.death.domain.Excercise;
import com.example.death.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcerciseServiceImpl implements ExcerciseService {

    @Autowired
    private ExcerciseDao dao;

    @Override
    public Optional<Excercise> findByExcerciseName(String name) {
        return dao.findByExcerciseName(name);
    }

    @Override
    public List<Excercise> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Excercise> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(Excercise entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, Excercise entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }
}
