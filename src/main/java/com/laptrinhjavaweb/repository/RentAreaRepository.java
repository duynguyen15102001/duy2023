package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends JpaRepository<RentAreaEntity, Long> {

    List<RentAreaEntity> findByBuildingId(Long buildingId);
    RentAreaEntity findByBuildingIdAndValue(Long buildingId,Integer value);
    void deleteByBuildingIdIn(List<Long> buildingIds);
    void deleteByValueInAndBuildingId(List<Integer> buildingIds , Long buildingId);



}
