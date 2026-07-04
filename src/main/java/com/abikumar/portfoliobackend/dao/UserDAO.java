package com.abikumar.portfoliobackend.dao;

import com.abikumar.portfoliobackend.dto.UserDTO;

public interface UserDAO {

	public int registerUser(UserDTO userDTO);

	public UserDTO getUserByEmail(String email);

	public int updatePassword(String email, String password);
}