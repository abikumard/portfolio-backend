package com.abikumar.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abikumar.portfoliobackend.dto.SkillDTO;
import com.abikumar.portfoliobackend.service.SkillService;

@RestController
@RequestMapping("/skill")
@CrossOrigin("*")
public class SkillController {

	@Autowired
	private SkillService skillService;

	@PostMapping("/save")
	public String saveSkill(@RequestBody SkillDTO dto) {

		return skillService.saveSkill(dto);
	}

	@GetMapping("/list")
	public List<SkillDTO> getAllSkills() {

		return skillService.getAllSkills();
	}

	@PutMapping("/update")
	public String updateSkill(@RequestBody SkillDTO dto) {

		return skillService.updateSkill(dto);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteSkill(@PathVariable Long id) {

		return skillService.deleteSkill(id);
	}
}