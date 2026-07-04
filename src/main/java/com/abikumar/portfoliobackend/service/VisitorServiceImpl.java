package com.abikumar.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.VisitorDAO;
import com.abikumar.portfoliobackend.dto.VisitorDTO;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorDAO visitorDAO;

	@Override
	public String saveVisit(VisitorDTO dto) {

		int result = visitorDAO.saveVisit(dto);

		if (result > 0) {
			return "Visit Saved";
		}

		return "Failed";
	}

	@Override
	public int getTotalVisitors() {

		return visitorDAO.getTotalVisitors();
	}
}
