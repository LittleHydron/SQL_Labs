package com.example.service.impl;

import com.example.repository.ProceduresRepository;
import com.example.service.ProceduresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProceduresServiceImpl implements ProceduresService {
    @Autowired
    ProceduresRepository proceduresRepository;

    @Override
    public void insertNamesIntoTrainerWorksIn(int trainerId, int gymId) {
        proceduresRepository.insertNamesIntoTrainerWorksIn(trainerId, gymId);
    }

    @Override
    public void insertIntoSimulator(String simulatorName) {
        proceduresRepository.insertIntoSimulator(simulatorName);
    }

    @Override
    public void insertLinesToSimulator(int numberOfLines) {
        proceduresRepository.insertLinesToSimulator(numberOfLines);
    }

    @Override
    public Double callMaxSalary(){
        return proceduresRepository.callMaxSalary();
    }

    @Override
    public void procCursor(){
        proceduresRepository.procCursor();
    }
}
