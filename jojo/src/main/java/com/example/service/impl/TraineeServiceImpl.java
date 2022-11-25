package com.example.service.impl;

import com.example.domain.Trainee;
import com.example.exception.TraineeNotFoundException;
import com.example.repository.TraineeRepository;
import com.example.service.TraineeService;
import com.example.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService {
    @Autowired
    TraineeRepository traineeRepository;
    @Autowired
    TrainerService trainerService;

    @Transactional
    @Override
    public void update(Integer id, Trainee uTrainee) {
        Trainee trainee = traineeRepository.findById(id)
                .orElseThrow(() -> new TraineeNotFoundException(id));
        //update
        trainee.setTrainer(trainerService.findById(uTrainee.getId()));
        trainee.setTelephoneNumber(uTrainee.getTelephoneNumber());
        trainee.setName(uTrainee.getName());
        trainee.setDateOfRegistration(uTrainee.getDateOfRegistration());
        traineeRepository.save(trainee);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Trainee trainee = traineeRepository.findById(id)
                .orElseThrow(() -> new TraineeNotFoundException(id));
        traineeRepository.delete(trainee);
    }

    @Override
    public Trainee findById(Integer id) {
        return traineeRepository.findById(id).orElseThrow(() -> new TraineeNotFoundException(id));
    }

    @Transactional
    @Override
    public Trainee create(Trainee entity) {
        return traineeRepository.save(entity);
    }

    @Override
    public List<Trainee> findAll() {
        return traineeRepository.findAll();
    }
}
