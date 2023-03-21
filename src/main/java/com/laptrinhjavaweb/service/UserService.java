package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.input.AssignmentBuildingSearchInput;
import com.laptrinhjavaweb.response.StaffReponse;

import java.util.List;
import java.util.Map;

public interface UserService  {
    List<StaffReponse> findAllStaff();


    Map<Long,String> getStaffMaps();

}
