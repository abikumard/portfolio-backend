package com.abikumar.portfoliobackend.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
public interface ResumeService {

	public String uploadResume(MultipartFile file);


	 public Resource downloadResume();
}
