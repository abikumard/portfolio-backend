package com.abikumar.portfoliobackend.service;

import com.abikumar.portfoliobackend.dao.HRDAO;
import com.abikumar.portfoliobackend.dto.HRDetailsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class HRServiceImpl implements HRService {

	@Autowired
	private HRDAO hrDAO;
	private static final Logger logger = LoggerFactory.getLogger(HRServiceImpl.class);

	@Override
	public String saveHRDetails(HRDetailsDTO dto) {

		try {

			logger.info("HR Save Started");

			logger.info("HR Name : {}", dto.getHrName());

			logger.info("Company : {}", dto.getCompanyName());

			int result = hrDAO.saveHRDetails(dto);

			if (result > 0) {

				logger.info("HR Details Saved Successfully");

				return "Details Saved Successfully";
			}

			logger.warn("HR Details Save Failed");

			return "Save Failed";

		} catch (Exception e) {

			logger.error("Error while saving HR Details", e);

			return "Error Occurred";
		}
	}

	@Override
	public List<HRDetailsDTO> getAllHRDetails() {

		return hrDAO.getAllHRDetails();
	}
}