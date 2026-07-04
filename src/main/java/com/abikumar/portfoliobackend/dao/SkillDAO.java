package com.abikumar.portfoliobackend.dao;

import java.util.List;

import com.abikumar.portfoliobackend.dto.SkillDTO;

public interface SkillDAO {

	int saveSkill(SkillDTO dto);

	List<SkillDTO> getAllSkills();

	int updateSkill(SkillDTO dto);

	int deleteSkill(Long id);

}