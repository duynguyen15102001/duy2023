package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.AssignmentBuildingSearchInput;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/assignmentbuilding")
public class AssignmentBuildingAPI {

    @Autowired
    private IAssignmentBuildingService assignmentBuildingService;

    @PostMapping()
    public ResponseEntity<BuildingDTO> assignStaffManageBuilding(@RequestBody AssignmentBuildingSearchInput assignmentBuildingSearchInput) {

        return ResponseEntity.ok(assignmentBuildingService.buildingDelivery(assignmentBuildingSearchInput));

    }

}
