package com.example.service.impl;

import com.example.domain.Trainer;
import com.example.exception.TrainerNotFoundException;
import com.example.repository.TrainerRepository;
import com.example.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    @Transactional
    @Override
    public void update(Integer id, Trainer uTrainer) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new TrainerNotFoundException(id));
        //update
        trainer.setSalaryInDollars(uTrainer.getSalaryInDollars());
        trainer.setName(uTrainer.getName());
        trainer.setDateOfRegistration(uTrainer.getDateOfRegistration());
        trainerRepository.save(trainer);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new TrainerNotFoundException(id));
        trainerRepository.delete(trainer);
    }

    @Override
    public Trainer findById(Integer id) {
        return trainerRepository.findById(id).orElseThrow(() -> new TrainerNotFoundException(id));
    }

    @Transactional
    @Override
    public Trainer create(Trainer entity) {
        return trainerRepository.save(entity);
    }

    @Override
    public List<Trainer> findAll() {
        return trainerRepository.findAll();
    }
}
