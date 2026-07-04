package com.abikumar.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.SkillDAO;
import com.abikumar.portfoliobackend.dto.SkillDTO;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDAO;

	@Override
	public String saveSkill(SkillDTO dto) {

		int result = skillDAO.saveSkill(dto);

		if (result > 0) {
			return "Skill Saved Successfully";
		}

		return "Skill Save Failed";
	}

	@Override
	public List<SkillDTO> getAllSkills() {

		return skillDAO.getAllSkills();
	}

	@Override
	public String updateSkill(SkillDTO dto) {

		int result = skillDAO.updateSkill(dto);

		if (result > 0) {
			return "Skill Updated Successfully";
		}

		return "Skill Update Failed";
	}

	@Override
	public String deleteSkill(Long id) {

		int result = skillDAO.deleteSkill(id);

		if (result > 0) {
			return "Skill Deleted Successfully";
		}

		return "Skill Delete Failed";
	}
}