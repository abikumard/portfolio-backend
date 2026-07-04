package com.abikumar.portfoliobackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abikumar.portfoliobackend.dao.ProjectDAO;
import com.abikumar.portfoliobackend.dto.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public String saveProject(ProjectDTO dto) {

        int result = projectDAO.saveProject(dto);

        if (result > 0) {
            return "Project Saved Successfully";
        }

        return "Project Save Failed";
    }

    @Override
    public List<ProjectDTO> getAllProjects() {

        return projectDAO.getAllProjects();
    }

    @Override
    public String updateProject(ProjectDTO dto) {

        int result = projectDAO.updateProject(dto);

        if (result > 0) {
            return "Project Updated Successfully";
        }

        return "Project Update Failed";
    }

    @Override
    public String deleteProject(Long id) {

        int result = projectDAO.deleteProject(id);

        if (result > 0) {
            return "Project Deleted Successfully";
        }

        return "Project Delete Failed";
    }
}