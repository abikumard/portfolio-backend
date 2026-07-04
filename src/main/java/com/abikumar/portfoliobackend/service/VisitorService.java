package com.abikumar.portfoliobackend.service;

import com.abikumar.portfoliobackend.dto.VisitorDTO;

public interface VisitorService {

    String saveVisit(VisitorDTO dto);

    int getTotalVisitors();
}
