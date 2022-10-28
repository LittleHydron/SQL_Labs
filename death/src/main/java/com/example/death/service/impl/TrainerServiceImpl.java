package com.example.death.service.impl;

import com.example.death.dao.TrainerDao;
import com.example.death.domain.Trainer;
import com.example.death.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    private TrainerDao dao;

    @Override
    public List<Trainer> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Trainer> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(Trainer entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, Trainer entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }

    @Override
    public List<Trainer> findByName(String name) {
        return dao.findByName(name);
    }
}
