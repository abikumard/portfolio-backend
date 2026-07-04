package com.abikumar.portfoliobackend.service;

import java.util.List;

import com.abikumar.portfoliobackend.dto.ExperienceDTO;

public interface ExperienceService {

	String saveExperience(ExperienceDTO dto);

	List<ExperienceDTO> getAllExperience();

	String updateExperience(ExperienceDTO dto);

	String deleteExperience(Long id);

}