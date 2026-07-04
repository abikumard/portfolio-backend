package com.abikumar.portfoliobackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.VisitorDTO;

@Repository
public class VisitorDAOImpl implements VisitorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveVisit(VisitorDTO dto) {

        String sql = """
            INSERT INTO visitor_analytics
            (ip_address,page_name)
            VALUES (?,?)
            """;

        return jdbcTemplate.update(
                sql,
                dto.getIpAddress(),
                dto.getPageName());
    }

    @Override
    public int getTotalVisitors() {

        String sql =
                "SELECT COUNT(*) FROM visitor_analytics";

        return jdbcTemplate.queryForObject(
                sql,
                Integer.class);
    }
}