package com.example.death.service;

import com.example.death.domain.Gym;

import java.util.Optional;

public interface GymService extends GeneralService<Gym, Integer> {
    Optional<Gym> getByAddress(String address);
}
