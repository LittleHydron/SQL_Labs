package com.example.death.controller.impl;

import com.example.death.controller.GymController;
import com.example.death.domain.Gym;
import com.example.death.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymControllerImpl implements GymController {

    @Autowired
    private GymService service;

    @Override
    public List<Gym> findAll() {
        return service.findAll();
    }

    @Override
    public Optional<Gym> findById(Integer integer) {
        return service.findById(integer);
    }

    @Override
    public int create(Gym entity) {
        return service.create(entity);
    }

    @Override
    public int update(Integer integer, Gym entity) {
        return service.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return service.delete(integer);
    }

    @Override
    public Optional<Gym> getByAddress(String address) {
        return service.getByAddress(address);
    }
}
