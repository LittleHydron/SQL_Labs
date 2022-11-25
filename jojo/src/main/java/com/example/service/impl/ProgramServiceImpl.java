package com.example.service.impl;

import com.example.domain.Program;
import com.example.exception.ProgramNotFoundException;
import com.example.repository.ProgramRepository;
import com.example.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    ProgramRepository programRepository;

    @Transactional
    @Override
    public void update(Integer id, Program uProgram) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException(id));
        //update
        program.setDificultyLevel(uProgram.getDifficultyLevel());
        program.setName(uProgram.getName());
        programRepository.save(program);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Program program = programRepository.findById(id)
                .orElseThrow(() -> new ProgramNotFoundException(id));
        programRepository.delete(program);
    }

    @Override
    public Program findById(Integer id) {
        return programRepository.findById(id).orElseThrow(() -> new ProgramNotFoundException(id));
    }

    @Transactional
    @Override
    public Program create(Program entity) {
        return programRepository.save(entity);
    }

    @Override
    public List<Program> findAll() {
        return programRepository.findAll();
    }
}
