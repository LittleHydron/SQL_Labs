package com.example.death.dao.impl;

import com.example.death.dao.TrainerWorksInDao;
import com.example.death.domain.ProgramContains;
import com.example.death.domain.TrainerWorksIn;
import org.springframework.data.util.Pair;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class TrainerWorksInDaoImpl implements TrainerWorksInDao {
    private final static String FIND_ALL = "SELECT * FROM TrainerWorksIn";
    private final static String CREATE = "INSERT TrainerWorksIn(gym_ID, trainer_ID) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE TrainerWorksIn SET gym_ID=?, trainer_ID=? WHERE gym_ID=? AND trainer_ID=?";
    private final static String DELETE = "DELETE FROM TrainerWorksIn WHERE gym_ID=? AND trainer_ID=?";
    private final static String FIND_IDs = "SELECT trainer_ID FROM TrainerWorksIn WHERE gym_ID=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TrainerWorksIn> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(TrainerWorksIn.class));
    }

    @Override
    public Optional<TrainerWorksIn> findById(Pair<Integer, Integer> id) {
        return Optional.empty();
    }

    @Override
    public int create(TrainerWorksIn entity) {
        return jdbcTemplate.update(CREATE, entity.getGym_ID(), entity.getTrainer_ID());
    }

    @Override
    public int update(Pair<Integer, Integer> id, TrainerWorksIn entity) {
        return jdbcTemplate.update(UPDATE, id.getFirst(), id.getSecond(), entity.getGym_ID(), entity.getTrainer_ID());
    }

    @Override
    public int delete(Pair<Integer, Integer> id) {
        return jdbcTemplate.update(DELETE, id.getFirst(), id.getSecond());
    }

    @Override
    public List<Integer> findTrainerIDs(Integer gym_ID) {
        return jdbcTemplate.query(FIND_IDs, BeanPropertyRowMapper.newInstance(Integer.class), gym_ID);
    }
}
