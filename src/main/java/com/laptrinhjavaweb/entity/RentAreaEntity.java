package com.laptrinhjavaweb.entity;

import com.laptrinhjavaweb.entity.BaseEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity {


    @Column(name = "value")
    private Integer value;


    public Integer getValue() {
        return value;
    }

    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;

    public void setValue(Integer value) {
        this.value = value;
    }

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }
}
