package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {

    List<BuildingEntity> getBuilding(Map<String, Object> buildingSearchMapping, List<String> listRentType);

    List<BuildingEntity> findBuilding(BuildingSearchBuilder builder,Pageable pageable);

/*    List<BuildingEntity> findBuilding(BuildingSearchBuilder builder,Pageable pageable);*/
    int countTotalItem(BuildingSearchBuilder builder);

    List<BuildingEntity> findBuildingByAssignUser(Long id);


}
