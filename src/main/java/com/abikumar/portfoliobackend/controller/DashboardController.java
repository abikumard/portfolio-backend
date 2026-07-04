package com.abikumar.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abikumar.portfoliobackend.dto.DashboardDTO;
import com.abikumar.portfoliobackend.service.DashboardService;

@RestController
@RequestMapping("/admin")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("/dashboard")
	public DashboardDTO getDashboard() {

		return dashboardService.getDashboard();
	}
}