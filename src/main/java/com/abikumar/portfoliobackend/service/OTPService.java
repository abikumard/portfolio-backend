package com.abikumar.portfoliobackend.service;

public interface OTPService {

    public String sendOTP(String email);

    public String verifyOTP(String email,String otp);
    public String resendOTP(String email);
}