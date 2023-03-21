package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.custom.DistrictRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DistrictRepositoryImpl implements DistrictRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DistrictEntity findByDistrictId(Long districtId) {
        String sql = "SELECT d.name FROM Building b join district d on b.districtid = d.id where d.id = '"+districtId+"'";
        Query query = entityManager.createNativeQuery(sql.toString(), DistrictEntity.class);
        // tra du lieu ra
        return (DistrictEntity) query.getSingleResult();
    }
}
