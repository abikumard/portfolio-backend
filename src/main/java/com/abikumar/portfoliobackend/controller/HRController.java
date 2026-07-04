package com.abikumar.portfoliobackend.controller;

import com.abikumar.portfoliobackend.dto.HRDetailsDTO;
import com.abikumar.portfoliobackend.service.HRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
@CrossOrigin("*")
public class HRController {

    @Autowired
    private HRService hrService;

    @PostMapping("/save")
    public String save(
            @RequestBody HRDetailsDTO dto) {

        return hrService.saveHRDetails(dto);
    }

    @GetMapping("/list")
    public List<HRDetailsDTO> getAll() {

        return hrService.getAllHRDetails();
    }
}