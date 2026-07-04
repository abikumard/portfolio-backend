package com.abikumar.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import com.abikumar.portfoliobackend.dto.LoginDTO;
import com.abikumar.portfoliobackend.dto.ResetPasswordDTO;
import com.abikumar.portfoliobackend.dto.UserDTO;
import com.abikumar.portfoliobackend.response.CommonResponse;
import com.abikumar.portfoliobackend.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@GetMapping("/redis-test")
	public String testRedis() {

		redisTemplate.opsForValue().set("test", "working");

		return redisTemplate.opsForValue().get("test").toString();
	}

	@PostMapping("/register")
	public String register(@RequestBody UserDTO userDTO) {
		System.out.println("Name = " + userDTO.getFullName());
		System.out.println("Email = " + userDTO.getEmail());
		return userService.register(userDTO);

	}

	@PostMapping("/login")
	public CommonResponse login(@RequestBody LoginDTO loginDTO) {

		return userService.login(loginDTO);

	}

	@PostMapping("/reset-password")
	public String resetPassword(@RequestBody ResetPasswordDTO dto) {

		return userService.resetPassword(dto);
	}
}