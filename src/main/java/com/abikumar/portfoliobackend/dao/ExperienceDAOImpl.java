package com.abikumar.portfoliobackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.ExperienceDTO;

@Repository
public class ExperienceDAOImpl implements ExperienceDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveExperience(ExperienceDTO dto) {

		String sql = """
				INSERT INTO experience
				(
				    company,
				    designation,
				    duration,
				    description
				)
				VALUES
				(
				    ?,?,?,?
				)
				""";

		return jdbcTemplate.update(
				sql,
				dto.getCompany(),
				dto.getDesignation(),
				dto.getDuration(),
				dto.getDescription());

	}

	@Override
	public List<ExperienceDTO> getAllExperience() {

		String sql = "SELECT * FROM experience ORDER BY id DESC";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			ExperienceDTO dto = new ExperienceDTO();

			dto.setId(rs.getLong("id"));
			dto.setCompany(rs.getString("company"));
			dto.setDesignation(rs.getString("designation"));
			dto.setDuration(rs.getString("duration"));
			dto.setDescription(rs.getString("description"));

			return dto;
		});

	}

	@Override
	public int updateExperience(ExperienceDTO dto) {

		String sql = """
				UPDATE experience
				SET
				    company=?,
				    designation=?,
				    duration=?,
				    description=?
				WHERE id=?
				""";

		return jdbcTemplate.update(
				sql,
				dto.getCompany(),
				dto.getDesignation(),
				dto.getDuration(),
				dto.getDescription(),
				dto.getId());

	}

	@Override
	public int deleteExperience(Long id) {

		String sql = "DELETE FROM experience WHERE id=?";

		return jdbcTemplate.update(sql, id);

	}

}