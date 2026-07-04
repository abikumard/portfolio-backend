package com.abikumar.portfoliobackend.dao;

import java.util.List;

import com.abikumar.portfoliobackend.dto.ProjectDTO;

public interface ProjectDAO {

    int saveProject(ProjectDTO dto);

    List<ProjectDTO> getAllProjects();

    int updateProject(ProjectDTO dto);

    int deleteProject(Long id);
}