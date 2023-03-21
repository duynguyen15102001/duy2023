package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends CustomerRepositoryCustom, JpaRepository<CustomerEntity, Long> {
    Long countByIdIn(List<Long> customerIds);
    void deleteByIdIn(List<Long> buildingIds);

}
