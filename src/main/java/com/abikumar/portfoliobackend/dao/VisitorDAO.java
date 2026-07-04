package com.abikumar.portfoliobackend.dao;

import com.abikumar.portfoliobackend.dto.VisitorDTO;

public interface VisitorDAO {

    int saveVisit(VisitorDTO dto);

    int getTotalVisitors();
}