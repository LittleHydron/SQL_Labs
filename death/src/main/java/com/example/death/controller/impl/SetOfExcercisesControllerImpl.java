package com.example.death.controller.impl;

import com.example.death.controller.SetOfExcercisesController;
import com.example.death.domain.SetOfExcercises;
import com.example.death.service.SetOfExcercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetOfExcercisesControllerImpl implements SetOfExcercisesController {

    @Autowired
    SetOfExcercisesService service;

    @Override
    public List<SetOfExcercises> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<SetOfExcercises> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(SetOfExcercises entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, SetOfExcercises entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }

    @Override
    public List<SetOfExcercises> findByTrainerID(Integer trainer_ID) {
        return service.findByTrainerID(trainer_ID);
    }
}
