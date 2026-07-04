package com.abikumar.portfoliobackend.dto;

import lombok.Data;

@Data
public class OTPVerifyDTO {

    private String email;
    private String otp;
}