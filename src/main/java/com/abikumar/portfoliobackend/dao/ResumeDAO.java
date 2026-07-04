package com.abikumar.portfoliobackend.dao;

import com.abikumar.portfoliobackend.dto.ResumeDTO;

public interface ResumeDAO {

	int saveResume(String fileName, String filePath);

	ResumeDTO getLatestResume();
}