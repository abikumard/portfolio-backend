package com.abikumar.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.ExperienceDAO;
import com.abikumar.portfoliobackend.dto.ExperienceDTO;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceDAO experienceDAO;

	@Override
	public String saveExperience(ExperienceDTO dto) {

		int result = experienceDAO.saveExperience(dto);

		if (result > 0) {

			return "Experience Saved Successfully";
		}

		return "Experience Save Failed";

	}

	@Override
	public List<ExperienceDTO> getAllExperience() {

		return experienceDAO.getAllExperience();

	}

	@Override
	public String updateExperience(ExperienceDTO dto) {

		int result = experienceDAO.updateExperience(dto);

		if (result > 0) {

			return "Experience Updated Successfully";
		}

		return "Experience Update Failed";

	}

	@Override
	public String deleteExperience(Long id) {

		int result = experienceDAO.deleteExperience(id);

		if (result > 0) {

			return "Experience Deleted Successfully";
		}

		return "Experience Delete Failed";

	}

}