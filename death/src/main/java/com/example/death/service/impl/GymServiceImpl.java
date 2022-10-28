package com.example.death.service.impl;

import com.example.death.dao.GymDao;
import com.example.death.domain.Gym;
import com.example.death.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymServiceImpl implements GymService {

    @Autowired
    private GymDao dao;

    @Override
    public List<Gym> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Gym> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(Gym entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, Gym entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }

    @Override
    public Optional<Gym> getByAddress(String address) {
        return dao.getByAddress(address);
    }
}
