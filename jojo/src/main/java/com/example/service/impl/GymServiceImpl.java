package com.example.service.impl;

import com.example.domain.Gym;
import com.example.exception.GymNotFoundException;
import com.example.repository.GymRepository;
import com.example.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GymServiceImpl implements GymService {
    @Autowired
    GymRepository gymRepository;

    @Transactional
    @Override
    public void update(Integer id, Gym uGym) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new GymNotFoundException(id));
        //update
        gym.setDateOfCreation(uGym.getDateOfCreation());
        gym.setAddress(uGym.getAddress());
        gym.setName(uGym.getName());
        gymRepository.save(gym);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new GymNotFoundException(id));
        gymRepository.delete(gym);
    }

    @Override
    public Gym findById(Integer id) {
        return gymRepository.findById(id).orElseThrow(() -> new GymNotFoundException(id));
    }

    @Transactional
    @Override
    public Gym create(Gym entity) {
        return gymRepository.save(entity);
    }

    @Override
    public List<Gym> findAll() {
        return gymRepository.findAll();
    }
}
