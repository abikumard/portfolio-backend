package com.abikumar.portfoliobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abikumar.portfoliobackend.service.ResumeService;

import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/resume")
@CrossOrigin("*")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;

	@PostMapping("/upload")
	public String uploadResume(@RequestParam("file") MultipartFile file) {

		return resumeService.uploadResume(file);
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> downloadResume() {

		Resource resource = resumeService.downloadResume();

		return ResponseEntity.ok()

				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")

				.body(resource);
	}
}