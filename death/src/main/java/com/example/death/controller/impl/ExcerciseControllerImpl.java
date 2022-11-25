package com.example.death.controller.impl;

import com.example.death.controller.ExcerciseController;
import com.example.death.domain.Excercise;
import com.example.death.service.ExcerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExcerciseControllerImpl implements ExcerciseController {

    @Autowired
    private ExcerciseService service;

    @Override
    public Optional<Excercise> findByExcerciseName(String name) {
        return service.findByExcerciseName(name);
    }

    @Override
    public List<Excercise> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Excercise> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(Excercise entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, Excercise entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }
}
