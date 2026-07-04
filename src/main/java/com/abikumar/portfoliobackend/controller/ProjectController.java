package com.abikumar.portfoliobackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.abikumar.portfoliobackend.dto.ProjectDTO;
import com.abikumar.portfoliobackend.service.ProjectService;

@RestController
@RequestMapping("/project")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/save")
    public String saveProject(
            @RequestBody ProjectDTO dto) {

        return projectService.saveProject(dto);
    }

    @GetMapping("/list")
    public List<ProjectDTO> getAllProjects() {

        return projectService.getAllProjects();
    }

    @PutMapping("/update")
    public String updateProject(
            @RequestBody ProjectDTO dto) {

        return projectService.updateProject(dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProject(
            @PathVariable Long id) {

        return projectService.deleteProject(id);
    }
}