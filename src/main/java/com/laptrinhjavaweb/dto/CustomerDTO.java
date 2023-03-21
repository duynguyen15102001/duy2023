package com.laptrinhjavaweb.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerDTO extends AbstractDTO<CustomerDTO>{
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;
    private String createdBy;
    private Date createdDate;
    private String staffNames;
    private Map<Long, String> staffs = new HashMap<>();
    private String companyName;
    private String note;
    private String demand;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Map<Long, String> getStaffs() {
        return staffs;
    }

    public void setStaffs(Map<Long, String> staffs) {
        this.staffs = staffs;
    }

    public String getStaffNames() {
        return staffNames;
    }

    public void setStaffNames(String staffNames) {
        this.staffNames = staffNames;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }
}
