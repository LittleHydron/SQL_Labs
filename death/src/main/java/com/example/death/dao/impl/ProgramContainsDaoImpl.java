package com.example.death.dao.impl;

import com.example.death.dao.ProgramContainsDao;
import com.example.death.domain.ProgramContains;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ProgramContainsDaoImpl implements ProgramContainsDao {

    private final static String FIND_ALL = "SELECT * FROM ProgramContains";
    private final static String CREATE = "INSERT ProgramContains(Excercise_ID, Program_ID) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE ProgramContains SET Excercise_ID=?, Program_ID=? WHERE Excercise_ID=? AND Program_ID=?";
    private final static String DELETE = "DELETE FROM ProgramContains WHERE Excercise_ID=? AND Program_ID=?";
    private final static String FIND_IDs = "SELECT Excercise_ID FROM ProgramContains WHERE Program_ID=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProgramContains> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ProgramContains.class));
    }

    @Override
    public Optional<ProgramContains> findById(Pair<Integer, Integer> id) {
        return Optional.empty();
    }

    @Override
    public int create(ProgramContains entity) {
        return jdbcTemplate.update(CREATE, entity.getExcercise_ID(), entity.getProgram_ID());
    }

    @Override
    public int update(Pair<Integer, Integer> id, ProgramContains entity) {
        return jdbcTemplate.update(UPDATE, id.getFirst(), id.getSecond(), entity.getExcercise_ID(), entity.getProgram_ID());
    }

    @Override
    public int delete(Pair<Integer, Integer> id) {
        return jdbcTemplate.update(DELETE, id.getFirst(), id.getSecond());
    }

    @Override
    public List<Integer> findExcerciseIDs(Integer programID) {
        return jdbcTemplate.query(FIND_IDs, BeanPropertyRowMapper.newInstance(Integer.class), programID);
    }
}
