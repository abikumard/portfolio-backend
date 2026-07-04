package com.abikumar.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abikumar.portfoliobackend.dto.ExperienceDTO;
import com.abikumar.portfoliobackend.service.ExperienceService;

@RestController
@RequestMapping("/experience")
@CrossOrigin("*")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;

	@PostMapping("/save")
	public String saveExperience(@RequestBody ExperienceDTO dto) {

		return experienceService.saveExperience(dto);

	}

	@GetMapping("/list")
	public List<ExperienceDTO> getAllExperience() {

		return experienceService.getAllExperience();

	}

	@PutMapping("/update")
	public String updateExperience(@RequestBody ExperienceDTO dto) {

		return experienceService.updateExperience(dto);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteExperience(@PathVariable Long id) {

		return experienceService.deleteExperience(id);

	}

}