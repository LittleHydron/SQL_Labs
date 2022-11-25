package com.example.death.dao;

import com.example.death.domain.Gym;

import java.util.Optional;

public interface GymDao extends GeneralDao<Gym, Integer> {
    Optional<Gym> getByAddress(String address);
}
