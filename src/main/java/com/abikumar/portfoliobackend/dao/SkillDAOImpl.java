package com.abikumar.portfoliobackend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.SkillDTO;

@Repository
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveSkill(SkillDTO dto) {

		String sql = """
				INSERT INTO skills
				(
				    skill_name,
				    category
				)
				VALUES
				(
				    ?,?
				)
				""";

		return jdbcTemplate.update(
				sql,
				dto.getSkillName(),
				dto.getCategory());
	}

	@Override
	public List<SkillDTO> getAllSkills() {

		String sql = "SELECT * FROM skills ORDER BY id DESC";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			SkillDTO dto = new SkillDTO();

			dto.setId(rs.getLong("id"));
			dto.setSkillName(rs.getString("skill_name"));
			dto.setCategory(rs.getString("category"));

			return dto;
		});
	}

	@Override
	public int updateSkill(SkillDTO dto) {

		String sql = """
				UPDATE skills
				SET
				    skill_name=?,
				    category=?
				WHERE id=?
				""";

		return jdbcTemplate.update(
				sql,
				dto.getSkillName(),
				dto.getCategory(),
				dto.getId());
	}

	@Override
	public int deleteSkill(Long id) {

		String sql = "DELETE FROM skills WHERE id=?";

		return jdbcTemplate.update(sql, id);
	}
}