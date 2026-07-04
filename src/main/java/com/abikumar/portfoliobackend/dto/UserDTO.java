package com.abikumar.portfoliobackend.dto;

import lombok.Data;

@Data
public class UserDTO {

    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String role;
}