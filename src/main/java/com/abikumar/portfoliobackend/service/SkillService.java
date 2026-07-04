package com.abikumar.portfoliobackend.service;

import java.util.List;

import com.abikumar.portfoliobackend.dto.SkillDTO;

public interface SkillService {

	String saveSkill(SkillDTO dto);

	List<SkillDTO> getAllSkills();

	String updateSkill(SkillDTO dto);

	String deleteSkill(Long id);

}