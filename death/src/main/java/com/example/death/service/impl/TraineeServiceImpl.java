package com.example.death.service.impl;

import com.example.death.dao.TraineeDao;
import com.example.death.domain.Trainee;
import com.example.death.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    @Autowired
    private TraineeDao dao;

    @Override
    public List<Trainee> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Trainee> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(Trainee entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, Trainee entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }

    @Override
    public List<Trainee> findByName(String name) {
        return dao.findByName(name);
    }
}
