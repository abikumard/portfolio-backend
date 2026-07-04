package com.abikumar.portfoliobackend.service;

import java.util.List;

import com.abikumar.portfoliobackend.dto.ProjectDTO;

public interface ProjectService {

    String saveProject(ProjectDTO dto);

    List<ProjectDTO> getAllProjects();

    String updateProject(ProjectDTO dto);

    String deleteProject(Long id);
}