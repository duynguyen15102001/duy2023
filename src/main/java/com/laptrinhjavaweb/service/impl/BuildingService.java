package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.*;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.enums.TypeEnums;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.response.BuildingSearchReponse;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.UploadFileUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;
import javassist.NotFoundException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@Service
public class BuildingService implements IBuildingService {


    @Autowired
    private BuildingRepository buildingRepository;


    @Autowired
    private RentAreaRepository rentAreaRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private final BuildingConverter buildingConverter;

    private final UploadFileUtils uploadFileUtils;


    private List<String> convertBuildingType(String dbType) {
        List<String> results = new ArrayList<>();
        String[] typeArray = dbType.split(",");
        for (String item : typeArray) {
            results.add(TypeEnums.valueOf(item).getValue());
        }
        return results;
    }

    @Override
    public List<BuildingDTO> getBuilding(BuildingDTO buildingDTO, Pageable pageable) {
        List<BuildingDTO> results = new ArrayList<>();
        Long staffId = null;
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            staffId = SecurityUtils.getPrincipal().getId();
        }
        buildingDTO.setStaffId(staffId);
        BuildingSearchBuilder buildingSearchBuilder = convertToBuildingSearchBuilder(buildingDTO);
        List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(buildingSearchBuilder, pageable);
        BuildingDTO buildingDTO1 = new BuildingDTO();
        for (BuildingEntity item : buildingEntities) {
            buildingDTO1 = buildingConverter.convertToDto(item);
            results.add(buildingDTO1);
        }
        return results;
    }


    private BuildingSearchBuilder convertToBuildingSearchBuilder(BuildingDTO buildingDTO) {
        BuildingSearchBuilder result = new BuildingSearchBuilder.Builder()
                .setName(buildingDTO.getName())
                .setFloorArea(buildingDTO.getFloorArea())
                .setDistrict(buildingDTO.getDistrict())
                .setWard(buildingDTO.getWard())
                .setStreet(buildingDTO.getStreet())
                .setNumberOfBasement(buildingDTO.getNumberOfBasement())
                .setDirection(buildingDTO.getDirection())
                .setLevel(buildingDTO.getLevel())
                .setRentPriceFrom(buildingDTO.getRentPriceFrom())
                .setRentPriceTo(buildingDTO.getRentPriceTo())
                .setAreaRentFrom(buildingDTO.getAreaRentFrom())
                .setAreaRentTo(buildingDTO.getAreaRentTo())
                .setStaffId(buildingDTO.getStaffId())
                .setType(buildingDTO.getTypes())
                .build();
        return result;
    }


    @Override
    public List<BuildingSearchReponse> findAll() {
        List<BuildingEntity> entities = buildingRepository.findAll();
        List<BuildingSearchReponse> results = new ArrayList<>();
        for (BuildingEntity item : entities) {
            BuildingSearchReponse buildingSearchReponse = new BuildingSearchReponse();
            buildingSearchReponse = buildingConverter.convertEntityToBuildingSearchReponse(item);
            results.add(buildingSearchReponse);
        }
        return results;
    }

    @Override
    @Transactional
    public BuildingDTO updateBuilding(Long id, BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        BuildingEntity buildingEntityAdd = buildingRepository.save(buildingEntity);
        List<String> rentAreaInput = Arrays.asList(buildingDTO.getRentArea().split(","));
        List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
        List<RentAreaEntity> rentAreaEntitiesDB = rentAreaRepository.findByBuildingId(id);
        List<String> rentAreaCurrent = new ArrayList<>();
        List<Integer> rentAreaDelete = new ArrayList<>();
        for (RentAreaEntity item1 : rentAreaEntitiesDB) {
            if (rentAreaInput.contains(item1.getValue().toString())) {
                rentAreaCurrent.add(item1.getValue().toString());
            } else {
                rentAreaDelete.add(item1.getValue());
            }
        }
        for (String item : rentAreaInput) {
            if (!rentAreaCurrent.contains(item) && item != "") {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuilding(buildingEntity);
                rentAreaEntity.setValue(Integer.valueOf(item));
                rentAreaRepository.save(rentAreaEntity);
            }
        }

        rentAreaRepository.deleteByValueInAndBuildingId(rentAreaDelete, id);


        return buildingConverter.convertToDto(buildingEntityAdd);
    }

    @Override
    public BuildingDTO findBuildingById(Long id) {
        BuildingEntity entity = buildingRepository.findById(id).get();
        BuildingDTO buildingDTO = buildingConverter.convertEntityToBuildingDTO(entity);

        return buildingDTO;
    }

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> districts = new HashMap<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districts.put(item.toString(), item.getDistrictValue());
        }
        return districts;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> buildingTypes = new HashMap<>();
        for (TypeEnums item : TypeEnums.values()) {
            buildingTypes.put(item.toString(), item.getValue());
        }
        return buildingTypes;
    }


    private Map<String, Object> validateSearchParams(Map<String, Object> params) {

        Map<String, Object> validParams = new HashMap<>();

        for (Map.Entry<String, Object> item : params.entrySet()) {
            if (ValidateUtils.isValid(item.getValue())) {
                validParams.put(item.getKey().toLowerCase(), item.getValue());
            }
        }
        return validParams;
    }

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, BuildingConverter buildingConverter,
                           UploadFileUtils uploadFileUtils) {
        this.buildingRepository = buildingRepository;
        this.buildingConverter = buildingConverter;
        this.uploadFileUtils = uploadFileUtils;
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        Long buildingId = buildingDTO.getId();

        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);

        if (buildingId != null) { // update
            BuildingEntity foundBuilding = null;
            try {
                foundBuilding = buildingRepository.findById(buildingId)
                        .orElseThrow(() -> new NotFoundException("Building not found!"));
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            buildingEntity.setImage(foundBuilding.getImage());
        }
        saveThumbnail(buildingDTO, buildingEntity);
        return buildingConverter.convertToDto(buildingRepository.save(buildingEntity));
    }

    @Override
    @Transactional
    public void delete(List<Long> buildingIds) {
        if (!buildingIds.isEmpty()) {
            Long count = buildingRepository.countByIdIn(buildingIds);

            if (count != buildingIds.size()) {
                try {
                    throw new NotFoundException("Building not found!");
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
            }
            // remove buildings

            buildingRepository.deleteByIdIn(buildingIds);
        }
    }

    private void saveThumbnail(BuildingDTO buildingDTO, BuildingEntity buildingEntity) {
        String path = "/building/" + buildingDTO.getImageName();
        if (null != buildingDTO.getImageBase64()) {
            if (null != buildingEntity.getImage()) {
                if (!path.equals(buildingEntity.getImage())) {
                    File file = new File("C://home/office/building" + buildingEntity.getImage());
                    file.delete();
                }
            }
            byte[] bytes = Base64.decodeBase64(buildingDTO.getImageBase64().getBytes());
            uploadFileUtils.writeOrUpdate(path, bytes);
            buildingEntity.setImage(path);
        }
    }

    @Override
    public int getTotalItems(BuildingDTO buildingDTO) {
        int totalItem = 0;
        BuildingSearchBuilder buildingSearchBuilder = convertToBuildingSearchBuilder(buildingDTO);
        totalItem = (int) buildingRepository.countTotalItem(buildingSearchBuilder);
        return totalItem;
    }


}
