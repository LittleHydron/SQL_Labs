package com.example.death.dao.impl;

import com.example.death.dao.TrainerDao;
import com.example.death.domain.Trainer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TrainerDaoImpl implements TrainerDao {

    final static String FIND_ALL = "SELECT * FROM Trainer";
    final static String FIND_BY_ID = "SELECT * FROM Trainer WHERE ID=?";
    final static String CREATE = "INSERT Trainer(Name, Date_of_registration, Salary_in_dollars) VALUES(?, ?, ?)";
    final static String UPDATE = "UPDATE Trainer SET Name=?, Date_of_registration=?, Salary_in_dollars=? WHERE ID=?";
    final static String DELETE = "DELETE FROM Trainer WHERE ID=?";
    final static String FIND_BY_NAME = "SELECT * FROM Trainer WHERE Name=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Trainer> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Trainer.class));
    }

    @Override
    public Optional<Trainer> findById(Integer id) {
        Optional<Trainer> t;
        try{
            t = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Trainer.class), id));
        } catch(EmptyResultDataAccessException e){
            t = Optional.empty();
        }
        return t;
    }

    @Override
    public int create(Trainer trainer) {
        return jdbcTemplate.update(CREATE, trainer.getName(), trainer.getDate_of_registration(), trainer.getSalary_in_dollars());
    }

    @Override
    public int update(Integer id, Trainer trainer) {
        return jdbcTemplate.update(UPDATE, trainer.getName(), trainer.getDate_of_registration(), trainer.getSalary_in_dollars(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Trainer> findByName(String name) {
        return jdbcTemplate.query(FIND_BY_NAME, BeanPropertyRowMapper.newInstance(Trainer.class), name);
    }
}
