package com.abikumar.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.DashboardDAO;
import com.abikumar.portfoliobackend.dto.DashboardDTO;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private DashboardDAO dashboardDAO;

	@Override
	public DashboardDTO getDashboard() {

		DashboardDTO dto = new DashboardDTO();

		dto.setTotalUsers(dashboardDAO.getTotalUsers());

		dto.setTotalVisitors(dashboardDAO.getTotalVisitors());

		dto.setTotalHRRequests(dashboardDAO.getTotalHRRequests());

		dto.setTotalResumes(dashboardDAO.getTotalResumes());

		return dto;
	}
}
