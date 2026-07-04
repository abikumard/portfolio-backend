package com.abikumar.portfoliobackend.dao;

import java.util.List;

import com.abikumar.portfoliobackend.dto.ExperienceDTO;

public interface ExperienceDAO {

	int saveExperience(ExperienceDTO dto);

	List<ExperienceDTO> getAllExperience();

	int updateExperience(ExperienceDTO dto);

	int deleteExperience(Long id);

}