package com.abikumar.portfoliobackend.dto;

import lombok.Data;

@Data
public class DashboardDTO {

    private int totalUsers;
    private int totalVisitors;
    private int totalHRRequests;
    private int totalResumes;
}