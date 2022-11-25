package com.example.death.service;

import com.example.death.domain.Trainer;

import java.util.List;

public interface TrainerService extends GeneralService<Trainer, Integer> {
    List<Trainer> findByName(String name);
}