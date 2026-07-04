package com.abikumar.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abikumar.portfoliobackend.dto.VisitorDTO;
import com.abikumar.portfoliobackend.service.VisitorService;

@RestController
@RequestMapping("/visitor")
@CrossOrigin("*")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;

	@PostMapping("/save")
	public String saveVisit(@RequestBody VisitorDTO dto) {

		return visitorService.saveVisit(dto);
	}

	@GetMapping("/count")
	public int getCount() {

		return visitorService.getTotalVisitors();
	}
}