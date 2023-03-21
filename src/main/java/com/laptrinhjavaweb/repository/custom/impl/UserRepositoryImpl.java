package com.laptrinhjavaweb.repository.custom.impl;


import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public UserEntity findByNameAndPhoneUser(Long staffId) {
        String sql = "SELECT u.username FROM users u join assignmentbuilding ab on u.id = ab.staffid join building b on b.id = ab.buildingid where ab.buildingid = '"+staffId+"'";
        Query query = entityManager.createNativeQuery(sql.toString(), DistrictEntity.class);
        // tra du lieu ra
        return (UserEntity) query.getSingleResult();
    }

    @Override
    public List<UserEntity> findAllManagementStaff() {
        StringBuilder sql = new StringBuilder(
                "SELECT u.*" +
                        " FROM users u join user_role r on r.user_id = u.id left join assignmentbuilding a on a.staffid=u.id where r.role_id=2 " +
                        "and EXISTS (  " +
                        "    SELECT staffid  " +
                        "    FROM assignmentbuilding) "
                        );
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }
    @Override
    public List<UserEntity> findAllStaff() {
        StringBuilder sql = new StringBuilder(
                "select users.* from users join user_role on users.id = user_role.user_id where user_role.role_id = 2;");
        Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
        return query.getResultList();
    }
}
