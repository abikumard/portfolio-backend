package com.abikumar.portfoliobackend.service;

import com.abikumar.portfoliobackend.dto.HRDetailsDTO;
import java.util.List;

public interface HRService {

    String saveHRDetails(HRDetailsDTO dto);

    List<HRDetailsDTO> getAllHRDetails();
}