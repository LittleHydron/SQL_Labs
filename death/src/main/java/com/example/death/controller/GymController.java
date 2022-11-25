package com.example.death.controller;

import com.example.death.domain.Gym;

import java.util.Optional;

public interface GymController extends GeneralController<Gym, Integer> {
    Optional<Gym> getByAddress(String address);
}
