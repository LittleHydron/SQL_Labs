package com.example.death.controller;

import com.example.death.domain.Trainer;

import java.util.List;

public interface TrainerController extends GeneralController<Trainer, Integer> {
    List<Trainer> findByName(String name);
}