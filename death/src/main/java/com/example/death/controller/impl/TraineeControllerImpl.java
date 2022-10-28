package com.example.death.controller.impl;

import com.example.death.controller.TraineeController;
import com.example.death.domain.Trainee;
import com.example.death.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeControllerImpl implements TraineeController {

    @Autowired
    private TraineeService service;

    @Override
    public List<Trainee> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Trainee> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(Trainee entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, Trainee entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }

    @Override
    public List<Trainee> findByName(String name) {
        return service.findByName(name);
    }
}
