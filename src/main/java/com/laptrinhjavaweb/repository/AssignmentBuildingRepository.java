//package com.laptrinhjavaweb.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface AssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity,Long> {
//    List<AssignmentBuildingEntity> findByBuilding_id(Long buildingId);
//    AssignmentBuildingEntity findByUser_idAndBuilding_id(Long staffId , Long buildingId);
//    void deleteByUser_id(Long userId);
//    void deleteByBuildingIdIn(List<Long> buildingIds);
//    void deleteByUser_IdInAndBuildingId(List<Long> staffIds , Long buildingId);
//
//}
