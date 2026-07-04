package com.abikumar.portfoliobackend.service;

import com.abikumar.portfoliobackend.dto.LoginDTO;
import com.abikumar.portfoliobackend.dto.ResetPasswordDTO;
import com.abikumar.portfoliobackend.dto.UserDTO;
import com.abikumar.portfoliobackend.response.CommonResponse;

public interface UserService {

	public String register(UserDTO userDTO);

	public CommonResponse login(LoginDTO loginDTO);

	public String resetPassword(ResetPasswordDTO dto);

}