package com.abikumar.portfoliobackend.dto;

import lombok.Data;

@Data
public class ExperienceDTO {

    private Long id;

    private String company;

    private String designation;

    private String duration;

    private String description;

}