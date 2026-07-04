package com.abikumar.portfoliobackend.service;

import java.time.Duration;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OTPServiceImpl implements OTPService {

	@Autowired
	private MailService mailService;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private String generateOTP() {

		Random random = new Random();

		int otp = 100000 + random.nextInt(900000);

		return String.valueOf(otp);
	}

	@Override
	public String sendOTP(String email) {

		try {

			String otp = generateOTP();

			String key = "OTP_" + email;

			redisTemplate.opsForValue().set(key, otp, Duration.ofMinutes(5));
			mailService.sendOTP(email, otp);

			System.out.println("Generated OTP : " + otp);

			return "OTP Generated Successfully";

		} catch (Exception e) {

			e.printStackTrace();

			return "OTP Generation Failed";
		}
	}

	@Override
	public String resendOTP(String email) {

		try {

			String key = "OTP_" + email;

			redisTemplate.delete(key);

			String newOtp = generateOTP();

			redisTemplate.opsForValue().set(key, newOtp, Duration.ofMinutes(5));

			System.out.println("Resend OTP : " + newOtp);

			return "OTP Resent Successfully";

		} catch (Exception e) {

			e.printStackTrace();

			return "OTP Resend Failed";
		}
	}

	@Override
	public String verifyOTP(String email, String otp) {

		try {

			String key = "OTP_" + email;

			Object storedOtp = redisTemplate.opsForValue().get(key);

			if (storedOtp == null) {

				return "OTP Expired";
			}

			if (storedOtp.toString().equals(otp)) {

				redisTemplate.delete(key);

				redisTemplate.opsForValue().set("RESET_ALLOWED_" + email, "true", Duration.ofMinutes(5));

				return "OTP Verified";
			}
			return "Invalid OTP";

		} catch (Exception e) {

			e.printStackTrace();

			return "OTP Verification Failed";
		}
	}
}