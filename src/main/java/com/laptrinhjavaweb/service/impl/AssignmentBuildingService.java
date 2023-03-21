

package com.laptrinhjavaweb.service.impl;


import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.input.AssignmentBuildingSearchInput;

import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class AssignmentBuildingService implements IAssignmentBuildingService {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;


    @Override
    public List<AssignmentBuildingDTO> findAll() {
        return null;
    }

    @Override
    @Transactional
    public BuildingDTO buildingDelivery(AssignmentBuildingSearchInput assignmentBuildingSearchInput) {

        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setId(assignmentBuildingSearchInput.getBuildingId());

        List<Long> inputStaff = assignmentBuildingSearchInput.getStaffId();

        List<UserEntity> userEntity = userRepository.findAllById(inputStaff);

        buildingEntity.setUsers(userEntity);
        buildingEntity.setId(assignmentBuildingSearchInput.getBuildingId());
        return buildingConverter.convertToDto(buildingRepository.save(buildingEntity));


    }


}

