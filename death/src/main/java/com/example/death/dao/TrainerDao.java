package com.example.death.dao;

import com.example.death.domain.Trainer;

import java.util.List;

public interface TrainerDao extends GeneralDao<Trainer, Integer> {
    List<Trainer> findByName(String name);
}