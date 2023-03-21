package com.laptrinhjavaweb.dto;

public class AssignmentBuildingDTO {
    private Long id;
    private Long staffId;
    private Long BuildingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getBuildingId() {
        return BuildingId;
    }

    public void setBuildingId(Long buildingId) {
        BuildingId = buildingId;
    }

}
