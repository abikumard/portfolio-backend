package com.abikumar.portfoliobackend.dao;

import com.abikumar.portfoliobackend.dto.HRDetailsDTO;
import java.util.List;

public interface HRDAO {

   public  int saveHRDetails(HRDetailsDTO dto);

   public  List<HRDetailsDTO> getAllHRDetails();
}