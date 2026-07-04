package com.abikumar.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void sendOTP(String email, String otp) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(email);

		message.setSubject("Portfolio OTP Verification");

		message.setText("Your OTP is : " + otp);

		mailSender.send(message);
	}
}