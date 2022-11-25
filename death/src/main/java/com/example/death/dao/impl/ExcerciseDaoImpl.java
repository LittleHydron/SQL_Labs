package com.example.death.dao.impl;

import com.example.death.dao.ExcerciseDao;
import com.example.death.domain.Excercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ExcerciseDaoImpl implements ExcerciseDao {
    private static final String FIND_ALL = "SELECT * FROM Excercise";
    private static final String CREATE = "INSERT Excercise(Name, Number_of_reps, Distance_in_meters, Duration_in_min) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE Excercise SET Name=?, Number_of_reps=?, Distance_in_meters=?, Duration_in_min=? WHERE id=?";
    private static final String DELETE = "DELETE FROM Excercise WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM Excercise WHERE id=?";
    private static final String FIND_BY_NAME = "SELECT * FROM Excercise WHERE Name=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Excercise> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Excercise.class));
    }

    @Override
    public Optional<Excercise> findById(Integer id) {
        Optional<Excercise> ex;
        try {
            ex = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Excercise.class), id));
        } catch (EmptyResultDataAccessException e) {
            ex = Optional.empty();
        }
        return ex;
    }

    @Override
    public int create(Excercise excercise) {
        return jdbcTemplate.update(CREATE, excercise.getName(), excercise.getNumber_of_reps(),
                excercise.getDistance_in_meters(), excercise.getDuration_in_min());
    }

    @Override
    public int update(Integer id, Excercise excercise) {
        return jdbcTemplate.update(UPDATE, excercise.getName(), excercise.getNumber_of_reps(),
                excercise.getDistance_in_meters(), excercise.getDuration_in_min(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Excercise> findByExcerciseName(String name) {
        Optional<Excercise> ex;
        try {
            ex = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_NAME,
                    BeanPropertyRowMapper.newInstance(Excercise.class), name));
        } catch (EmptyResultDataAccessException e) {
            ex = Optional.empty();
        }
        return ex;
    }
}
