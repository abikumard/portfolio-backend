package com.abikumar.portfoliobackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.ResumeDTO;

@Repository
public class ResumeDAOImpl implements ResumeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveResume(String fileName, String filePath) {

		String sql = """
				INSERT INTO resumes
				(
				    file_name,
				    file_path
				)
				VALUES
				(
				    ?,?
				)
				""";

		return jdbcTemplate.update(sql, fileName, filePath);
	}

	@Override
	public ResumeDTO getLatestResume() {

		String sql = """
				SELECT *
				FROM resumes
				ORDER BY id DESC
				LIMIT 1
				""";

		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {

			ResumeDTO dto = new ResumeDTO();

			dto.setId(rs.getLong("id"));

			dto.setFileName(rs.getString("file_name"));

			dto.setFilePath(rs.getString("file_path"));

			return dto;
		});
	}
}
