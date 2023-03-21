package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    UserEntity findByNameAndPhoneUser(Long staffId);
    List<UserEntity> findAllManagementStaff();

    List<UserEntity> findAllStaff();
}
