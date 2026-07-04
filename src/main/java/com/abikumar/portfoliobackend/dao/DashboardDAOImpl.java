package com.abikumar.portfoliobackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardDAOImpl implements DashboardDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int getTotalUsers() {

		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users", Integer.class);
	}

	@Override
	public int getTotalVisitors() {

		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM visitor_analytics", Integer.class);
	}

	@Override
	public int getTotalHRRequests() {

		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hr_details", Integer.class);
	}

	@Override
	public int getTotalResumes() {

		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM resumes", Integer.class);
	}
}
