package com.example.death.dao.impl;

import com.example.death.dao.ProgramDao;
import com.example.death.domain.Program;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ProgramDaoImpl implements ProgramDao {

    private final static String FIND_ALL = "SELECT * FROM Program";
    private static final String FIND_BY_ID = "SELECT * FROM Program WHERE id=?";
    private static final String CREATE = "INSERT Program(Name, Dificulty_level) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE Program SET Name=?, Dificultu_level=? WHERE ID=?";
    private static final String DELETE = "DELETE FROM Program WHERE ID=?";
    private static final String FIND_BY_LEVEL = "SELECT * FROM Program WHERE Dificulty_level=?";

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Program> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Program.class));
    }

    @Override
    public Optional<Program> findById(Integer id) {
        Optional<Program> p;
        try{
            p = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, BeanPropertyRowMapper.newInstance(Program.class), id));
        } catch (EmptyResultDataAccessException e){
            p = Optional.empty();
        }
        return p;
    }

    @Override
    public int create(Program program) {
        return jdbcTemplate.update(CREATE, program.getName(), program.getDificulty_level());
    }

    @Override
    public int update(Integer id, Program program) {
        return jdbcTemplate.update(UPDATE, program.getName(), program.getDificulty_level(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Program> findByProgramDifficulty(Integer level) {
        return jdbcTemplate.query(FIND_BY_LEVEL, BeanPropertyRowMapper.newInstance(Program.class), level);
    }
}
