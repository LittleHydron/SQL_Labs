package com.example.death.controller.impl;

import com.example.death.controller.TrainerController;
import com.example.death.domain.Trainer;
import com.example.death.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerControllerImpl implements TrainerController {

    @Autowired
    private TrainerService service;

    @Override
    public List<Trainer> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Trainer> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(Trainer entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, Trainer entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }

    @Override
    public List<Trainer> findByName(String name) {
        return service.findByName(name);
    }
}
