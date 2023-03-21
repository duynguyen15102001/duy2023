//package com.laptrinhjavaweb.converter;
//
//import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AssignmentBuildingConverter {
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public AssignmentBuildingEntity convertToEntity(AssignmentBuildingDTO dto){
//        AssignmentBuildingEntity result = modelMapper.map(dto, AssignmentBuildingEntity.class);
//        return result;
//    }
//
//
//    public AssignmentBuildingDTO convertToDto (AssignmentBuildingEntity entity){
//        AssignmentBuildingDTO result = modelMapper.map(entity, AssignmentBuildingDTO.class);
//        return result;
//    }
//
//}
