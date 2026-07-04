package com.abikumar.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abikumar.portfoliobackend.dto.OTPRequestDTO;
import com.abikumar.portfoliobackend.dto.OTPVerifyDTO;
import com.abikumar.portfoliobackend.service.OTPService;

@RestController
@RequestMapping("/otp")
@CrossOrigin("*")
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/send")
    public String sendOTP(
            @RequestBody OTPRequestDTO dto){

        return otpService.sendOTP(
                dto.getEmail());
    }

    @PostMapping("/resend")
    public String resendOTP(
            @RequestBody OTPRequestDTO dto){

        return otpService.resendOTP(
                dto.getEmail());
    }

    @PostMapping("/verify")
    public String verifyOTP(
            @RequestBody OTPVerifyDTO dto){

        return otpService.verifyOTP(
                dto.getEmail(),
                dto.getOtp());
    }
}