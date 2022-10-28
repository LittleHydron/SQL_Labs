package com.example.death.dao.impl;

import com.example.death.dao.SetOfExcercisesDao;
import com.example.death.domain.SetOfExcercises;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SetOfExcercisesDaoImpl implements SetOfExcercisesDao {

    private final static String GET_ALL = "SELECT * FROM SetOfExcercises";
    private final static String FIND_BY_ID = "SELECT * FROM SetOfExcercises WHERE ID=?";
    private final static String CREATE = "INSERT SetOfExcercises(Program_ID, Trainer_ID, Trainee_ID, Date_of_start, Date_of_end) VALUES(?, ?, ?, ?, ?)";
    private final static String UPDATE = "UPDATE SetOfExcercises SET Program_ID=?, Trainer_ID=?, Trainee_ID=?, Date_of_start=?, Date_of_end=?" +
                                        "WHERE ID=?";
    private final static String DELETE = "DELETE FROM SetOfExcercises WHERE ID=?";
    private final static String FIND_BY_TRAINER = "SELECT * FROM SetOfExcercises WHERE Trainer_ID=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SetOfExcercises> findAll() {
        return jdbcTemplate.query(GET_ALL, BeanPropertyRowMapper.newInstance(SetOfExcercises.class));
    }

    @Override
    public Optional<SetOfExcercises> findById(Integer id) {
        Optional<SetOfExcercises> s;
        try{
            s = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(SetOfExcercises.class), id));
        } catch (EmptyResultDataAccessException e){
            s = Optional.empty();
        }
        return s;
    }

    @Override
    public int create(SetOfExcercises set) {
        return jdbcTemplate.update(CREATE, set.getProgram_ID(), set.getTrainer_ID(), set.getTrainee_ID(), set.getDate_of_start(), set.getDate_of_end());
    }

    @Override
    public int update(Integer id, SetOfExcercises set) {
        return jdbcTemplate.update(UPDATE, set.getProgram_ID(), set.getTrainer_ID(), set.getTrainee_ID(), set.getDate_of_start(), set.getDate_of_end(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<SetOfExcercises> findByTrainerID(Integer trainer_ID) {
        return jdbcTemplate.query(FIND_BY_TRAINER, BeanPropertyRowMapper.newInstance(SetOfExcercises.class), trainer_ID);
    }
}
