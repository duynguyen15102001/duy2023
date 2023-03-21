package com.laptrinhjavaweb.entity;

import javax.persistence.Column;

public class DistrictEntity {
    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}