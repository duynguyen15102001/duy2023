//package com.laptrinhjavaweb.repository.custom.impl;
//
//import com.laptrinhjavaweb.entity.UserEntity;
//import com.laptrinhjavaweb.repository.custom.AssignmentBuildingRepositoryCustom;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//public class AssignmentBuildingRepositoryImpl implements AssignmentBuildingRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<AssignmentBuildingEntity> findStaffAssignBuilding(Long id) {
//        StringBuilder sql = new StringBuilder(
//                "SELECT a.*" +
//                        " FROM users u join user_role r on r.user_id = u.id left join assignmentbuilding a on a.staffid=u.id where r.role_id=2 " +
//                        "and EXISTS (  " +
//                        "    SELECT staffid  " +
//                        "    FROM assignmentbuilding " +
//                        "    WHERE buildingid=" +
//                        "   "
//                        + id + ");");
//        Query query = entityManager.createNativeQuery(sql.toString(), AssignmentBuildingEntity.class);
//        return query.getResultList();
//    }
//
//    public List<UserEntity> findAssignmentBuildingById(Long id) {
//        StringBuilder sql = new StringBuilder(
//                "select u.* from assignmentbuilding a join users u on u.id=a.staffid  where buildingid= "+id);
//        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
//        return query.getResultList();
//
//    }
//    public List<AssignmentBuildingEntity> findAssignmentBuildingByStaffidAndBuildingid(Long id1 , Long id2) {
//        StringBuilder sql = new StringBuilder(
//                "select * from assignmentbuilding where staffid = "+id1+" and buildingid = "+id2+"");
//
//        Query query = entityManager.createNativeQuery(sql.toString(), AssignmentBuildingEntity.class);
//        return query.getResultList();
//    }
//}
