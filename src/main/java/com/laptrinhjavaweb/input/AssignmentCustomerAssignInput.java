package com.laptrinhjavaweb.input;

import java.util.List;

public class AssignmentCustomerAssignInput {
    private Long id;

    private Long customerId;
    private List<Long> staffId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getStaffId() {
        return staffId;
    }

    public void setStaffId(List<Long> staffId) {
        this.staffId = staffId;
    }
}
