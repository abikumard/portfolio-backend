package com.abikumar.portfoliobackend.dao;

import com.abikumar.portfoliobackend.dto.HRDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HRDAOImpl implements HRDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveHRDetails(HRDetailsDTO dto) {

		try {

			String sql = """
					INSERT INTO hr_details(hr_name,company_name,email,phone,requirement_details)VALUES(?,?,?,?,?)""";

			return jdbcTemplate.update(sql, dto.getHrName(), dto.getCompanyName(), dto.getEmail(), dto.getPhone(),
					dto.getRequirementDetails());

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<HRDetailsDTO> getAllHRDetails() {

		String sql = "SELECT * FROM hr_details";

		return jdbcTemplate.query(sql, (rs, rowNum) -> {

			HRDetailsDTO dto = new HRDetailsDTO();

			dto.setHrName(rs.getString("hr_name"));

			dto.setCompanyName(rs.getString("company_name"));

			dto.setEmail(rs.getString("email"));

			dto.setPhone(rs.getString("phone"));

			dto.setRequirementDetails(rs.getString("requirement_details"));

			return dto;
		});
	}
}