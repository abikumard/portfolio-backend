package com.abikumar.portfoliobackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.abikumar.portfoliobackend.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int updatePassword(String email, String password) {

		String sql = """
				UPDATE users
				SET password = ?
				WHERE email = ?
				""";

		return jdbcTemplate.update(sql, password, email);
	}

	@Override
	public UserDTO getUserByEmail(String email) {

		try {

			String sql = "SELECT * FROM users WHERE email=?";

			return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {

				UserDTO dto = new UserDTO();

				dto.setFullName(rs.getString("full_name"));

				dto.setEmail(rs.getString("email"));

				dto.setPhone(rs.getString("phone"));

				dto.setPassword(rs.getString("password"));
				dto.setRole(rs.getString("role"));

				return dto;

			}, email);

		} catch (Exception e) {

			e.printStackTrace();

			return null;

		}
	}

	@Override
	public int registerUser(UserDTO userDTO) {

		String sql = """
				INSERT INTO users
				(
				    full_name,
				    email,
				    phone,
				    password,
				    role
				)
				VALUES
				(
				    ?, ?, ?, ?, ?
				)
				""";

		return jdbcTemplate.update(sql, userDTO.getFullName(), userDTO.getEmail(), userDTO.getPhone(),
				userDTO.getPassword(), userDTO.getRole());
	}
}