package com.example.death.service.impl;

import com.example.death.dao.ProgramDao;
import com.example.death.domain.Program;
import com.example.death.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramDao dao;

    @Override
    public List<Program> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Program> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public int create(Program entity) {
        return dao.create(entity);
    }

    @Override
    public int update(Integer integer, Program entity) {
        return dao.update(integer, entity);
    }

    @Override
    public int delete(Integer integer) {
        return dao.delete(integer);
    }

    @Override
    public List<Program> findByProgramDifficulty(Integer level) {
        return dao.findByProgramDifficulty(level);
    }
}
