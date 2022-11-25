package com.example.death.dao.impl;

import com.example.death.dao.TraineeDao;
import com.example.death.domain.Trainee;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TraineeDaoImpl implements TraineeDao {

    final static String FIND_ALL = "SELECT * FROM Trainee";
    final static String FIND_BY_ID = "SELECT * FROM Trainee WHERE ID=?";
    final static String CREATE = "INSERT Trainee(Name, Date_of_registration, Telephone_number, Trainer_ID) VALUES(?, ?, ?, ?)";
    final static String UPDATE = "UPDATE Trainee SET Name=?, Date_of_registration=?, Telephone_number=?, Trainer_ID=? WHERE ID=?";
    final static String DELETE = "DELETE FROM Trainee WHERE ID=?";
    final static String FIND_BY_NAME = "SELECT * FROM Trainee WHERE Name=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Trainee> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Trainee.class));
    }

    @Override
    public Optional<Trainee> findById(Integer id) {
        Optional<Trainee> t;
        try{
            t = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Trainee.class), id));
        } catch(EmptyResultDataAccessException e){
            t = Optional.empty();
        }
        return t;
    }

    @Override
    public int create(Trainee trainee) {
        return jdbcTemplate.update(CREATE, trainee.getName(), trainee.getDate_of_registration(), trainee.getTelephone_number(), trainee.getTrainer_ID());
    }

    @Override
    public int update(Integer id, Trainee trainee) {
        return jdbcTemplate.update(UPDATE,
                trainee.getName(), trainee.getDate_of_registration(), trainee.getTelephone_number(), trainee.getTrainer_ID(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Trainee> findByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(Trainee.class), name);
    }
}
