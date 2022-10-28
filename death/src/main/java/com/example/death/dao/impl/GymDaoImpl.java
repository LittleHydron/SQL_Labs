package com.example.death.dao.impl;

import com.example.death.dao.GymDao;
import com.example.death.domain.Gym;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class GymDaoImpl implements GymDao {

    private final static String FIND_ALL = "SELECT * FROM Gym";
    private final static String FIND_BY_ID = "SELECT * FROM Gym WHERE id=?";
    private final static String CREATE = "INSERT Gym(name, adress, date_of_creation) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE Gym SET name=?, adress=?, date_of_creation=? WHERE id=?";
    private final static String DELETE = "DELETE FROM Gym WHERE id=?";
    private final static String FIND_BY_ADRESS = "SELECT * FROM Gym WHERE adress=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Gym> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Gym.class));
    }

    @Override
    public Optional<Gym> findById(Integer id) {
        Optional<Gym> gym;
        try{
            gym = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Gym.class), id));
        } catch(EmptyResultDataAccessException e){
            gym = Optional.empty();
        }
        return gym;
    }

    @Override
    public int create(Gym gym) {
        return jdbcTemplate.update(CREATE, gym.getName(), gym.getAdress(), gym.getDate_of_creation());
    }

    @Override
    public int update(Integer id, Gym gym) {
        return jdbcTemplate.update(UPDATE, gym.getName(), gym.getAdress(), gym.getDate_of_creation(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Gym> getByAddress(String address) {
        Optional<Gym> gym;
        try{
            gym = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ADRESS, BeanPropertyRowMapper.newInstance(Gym.class), address));
        } catch (EmptyResultDataAccessException e){
            gym = Optional.empty();
        }
        return gym;
    }
}
