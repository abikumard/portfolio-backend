package com.abikumar.portfoliobackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.abikumar.portfoliobackend.dao.ResumeDAO;
import com.abikumar.portfoliobackend.dto.ResumeDTO;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Value("${file.upload-dir}")
	private String uploadDir;

	@Autowired
	private ResumeDAO resumeDAO;
	@Override
	public Resource downloadResume() {

	    try {

	        ResumeDTO resume =resumeDAO.getLatestResume();

	        Path path = Paths.get(resume.getFilePath());

	        return new UrlResource( path.toUri());

	    } catch (MalformedURLException e) {

	        throw new RuntimeException("Resume Not Found");
	    }
	}
	@Override
	public String uploadResume(MultipartFile file) {

		try {

			String fileName = file.getOriginalFilename();

			Path path = Paths.get(uploadDir, fileName);

			Files.createDirectories(path.getParent());

			Files.write(path, file.getBytes());

			resumeDAO.saveResume(fileName, path.toString());

			return "Resume Uploaded Successfully";

		} catch (Exception e) {

			return "Resume Upload Failed";
		}
	}
}