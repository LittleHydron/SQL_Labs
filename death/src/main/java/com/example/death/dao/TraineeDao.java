package com.example.death.dao;

import com.example.death.domain.Trainee;

import java.util.List;

public interface TraineeDao extends GeneralDao<Trainee, Integer> {
    List<Trainee> findByName(String name);
}