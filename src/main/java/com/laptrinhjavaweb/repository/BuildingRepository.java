package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BuildingRepository extends BuildingRepositoryCustom, JpaRepository<BuildingEntity, Long> {

  /* void deleteBuilding(BuildingEntity buildingEntity);
   BuildingEntity insertBuilding(BuildingEntity buildingEntity);
   BuildingEntity updateBuilding(BuildingEntity buildingEntity);*/
   void deleteByIdIn(List<Long> buildingIds);

    Long countByIdIn(List<Long> buildingIds);
    Page<BuildingEntity> findAll(Pageable pageable);




}
