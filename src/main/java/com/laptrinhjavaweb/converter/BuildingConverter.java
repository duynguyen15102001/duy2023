package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.response.BuildingSearchReponse;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    public BuildingDTO convertToDto(BuildingEntity entity) {

        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        for (DistrictsEnum item : DistrictsEnum.values()) {
            if (entity.getDistrict() != null) {
                if (entity.getDistrict().equals(item.name())) {
                    entity.setDistrict(item.getDistrictValue());
                }
            }
        }
        result.setAddress(entity.getStreet() + ", " + entity.getWard() + "," + entity.getDistrict());
        return result;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        /*String type = String.join(",", dto.getType());*/
        String type = null;
        if (dto.getType() != null) {
            type = String.join(",", dto.getType());
        }
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);

        if (dto.getRentArea() != "") {
            List<String> rentAreaArray = Arrays.asList(dto.getRentArea().split(","));
            for (String item : rentAreaArray) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuilding(result);
                rentAreaEntity.setValue(Integer.valueOf(item));
                rentAreaRepository.save(rentAreaEntity);

            }
        }


        result.setType(type);

        return result;
    }

    public BuildingSearchReponse convertEntityToBuildingSearchReponse(BuildingEntity buildingEntity) {
        BuildingSearchReponse result = modelMapper.map(buildingEntity, BuildingSearchReponse.class);
        return result;
    }

    public BuildingDTO convertEntityToBuildingDTO(BuildingEntity buildingEntity) {
        BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
        List<Integer> value = ValidateUtils.isValid(buildingEntity.getRentAreas()) ? buildingEntity.getRentAreas().stream().map(RentAreaEntity::getValue).collect(Collectors.toList()) : new ArrayList<>();
        result.setRentArea(ValidateUtils.isValid(value) ? StringUtils.join(value, ",") : null);
        result.setTypes(buildingEntity.getType());


        return result;
    }
    public BuildingDTO convertToDtoInBuildingDetail(BuildingEntity buildingEntity) {
        BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
        List<Integer> value = ValidateUtils.isValid(buildingEntity.getRentAreas()) ? buildingEntity.getRentAreas().stream().map(RentAreaEntity::getValue).collect(Collectors.toList()) : new ArrayList<>();
        result.setRentArea(ValidateUtils.isValid(value) ? StringUtils.join(value, ",") : null);
        result.setTypes(buildingEntity.getType());


        return result;
    }

}
