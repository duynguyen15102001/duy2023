package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.input.BuildingSearchInput;
import com.laptrinhjavaweb.response.ResponseDTO;
import com.laptrinhjavaweb.response.StaffReponse;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

    @Autowired
    private BuildingService buildingService;


    @Autowired
    private IUserService userService;

    @PostMapping()
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO newBuilding) {
        return ResponseEntity.ok(buildingService.save(newBuilding));

    }


    @DeleteMapping
    public ResponseEntity<List<Long>> removeBuildings(@RequestBody List<Long> buildingIds) {
        buildingService.delete(buildingIds);
        ResponseEntity<List<Long>> response = ResponseEntity.ok(buildingIds);


        return response;
    }


    @GetMapping("/{buildingId}/staffs")
    public ResponseDTO loadStaff(@PathVariable("buildingId") Long buildingId) {
        ResponseDTO results = new ResponseDTO();
        BuildingSearchInput buildingSearchInput = new BuildingSearchInput();
        buildingSearchInput.setId(buildingId);
        List<StaffReponse> staffs = userService.findAllManagementStaff(buildingSearchInput);
        results.setMessage("success");
        results.setData(staffs);
        return results;
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable("id") long id, @RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(buildingService.updateBuilding(id, buildingDTO));
    }


}
