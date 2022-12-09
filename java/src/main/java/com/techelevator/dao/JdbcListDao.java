package com.techelevator.dao;

import com.techelevator.model.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcListDao implements  ListDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcListDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<List> getListsByGroup(String groupName) {
        return null;
    }
}
