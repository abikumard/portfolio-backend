package com.abikumar.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.UserDAO;
import com.abikumar.portfoliobackend.dto.LoginDTO;
import com.abikumar.portfoliobackend.dto.ResetPasswordDTO;
import com.abikumar.portfoliobackend.dto.UserDTO;
import com.abikumar.portfoliobackend.response.CommonResponse;
import com.abikumar.portfoliobackend.util.AESUtil;
import com.abikumar.portfoliobackend.util.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String register(UserDTO userDTO) {

		String encryptedPassword = AESUtil.encrypt(userDTO.getPassword());

		userDTO.setPassword(encryptedPassword);
		logger.info("User Registration Started");

		int result = userDAO.registerUser(userDTO);
		System.out.println("Result = " + result);

		if (result > 0) {
			logger.info("User Registered Successfully");
			return "User Registered Successfully";
		}
		logger.error("Registration Failed");
		return "Registration Failed";

	}

	@Override
	public CommonResponse login(LoginDTO loginDTO) {

		CommonResponse response = new CommonResponse();

		try {

			UserDTO dbUser = userDAO.getUserByEmail(loginDTO.getEmail());

			if (dbUser == null) {

				response.setStatusCode(404);
				response.setMessage("User Not Found");

				return response;
			}

			String encryptedPassword = AESUtil.encrypt(loginDTO.getPassword());

			if (encryptedPassword.equals(dbUser.getPassword())) {

				String token = jwtUtil.generateToken(loginDTO.getEmail(), dbUser.getRole());

				response.setStatusCode(200);
				response.setMessage("Login Success");
				response.setData(token);

				return response;
			}

			response.setStatusCode(401);
			response.setMessage("Invalid Password");

			return response;

		} catch (Exception e) {

			response.setStatusCode(500);
			response.setMessage("Internal Server Error");
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@Override
	public String resetPassword(ResetPasswordDTO dto) {

		try {

			Object allowed = redisTemplate.opsForValue().get("RESET_ALLOWED_" + dto.getEmail());

			if (allowed == null) {

				return "OTP Verification Required";
			}

			String encryptedPassword = AESUtil.encrypt(dto.getNewPassword());

			int result = userDAO.updatePassword(dto.getEmail(), encryptedPassword);

			if (result > 0) {

				redisTemplate.delete("RESET_ALLOWED_" + dto.getEmail());

				return "Password Updated Successfully";
			}

			return "User Not Found";

		} catch (Exception e) {

			logger.error("Reset Password Error", e);

			return "Password Reset Failed";
		}
	}
}