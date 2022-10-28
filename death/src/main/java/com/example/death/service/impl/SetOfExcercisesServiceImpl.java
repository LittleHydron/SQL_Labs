package com.example.death.service.impl;

import com.example.death.dao.SetOfExcercisesDao;
import com.example.death.domain.SetOfExcercises;
import com.example.death.service.SetOfExcercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetOfExcercisesServiceImpl implements SetOfExcercisesService {

    @Autowired
    private SetOfExcercisesDao dao;

    @Override
    public List<SetOfExcercises> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<SetOfExcercises> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(SetOfExcercises entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, SetOfExcercises entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }

    @Override
    public List<SetOfExcercises> findByTrainerID(Integer trainer_ID) {
        return dao.findByTrainerID(trainer_ID);
    }
}
