package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.DistrictEntity;

public interface DistrictRepositoryCustom {
    DistrictEntity findByDistrictId(Long districtId);
}
