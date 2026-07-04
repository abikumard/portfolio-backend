package com.abikumar.portfoliobackend.dto;

import lombok.Data;

@Data
public class ProjectDTO {

    private Long id;

    private String title;

    private String description;

    private String technologies;

    private String githubLink;

    private String liveLink;

    private String imageUrl;
}