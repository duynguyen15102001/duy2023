package com.laptrinhjavaweb.input;

import java.util.List;

public class AssignmentBuildingSearchInput {
    private Long id;

    private Long buildingId;
    private List<Long> staffId;

    private Long[] staffs;

    public Long[] getStaffs() {
        return staffs;
    }

    public void setStaffs(Long[] staffs) {
        this.staffs = staffs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public List<Long> getStaffId() {
        return staffId;
    }

    public void setStaffId(List<Long> staffId) {
        this.staffId = staffId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }


}
