package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.AssignmentBuildingSearchInput;

import java.util.List;

public interface IAssignmentBuildingService {
    List<AssignmentBuildingDTO> findAll();
    BuildingDTO buildingDelivery(AssignmentBuildingSearchInput assignmentBuildingSearchInput);
}
