package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {

    private String name;
    private String district;
    private Integer buildingArea;
    private String street;
    private String ward;
    private Integer numberOfBasement;

    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private Integer areaRentFrom;
    private Integer areaRentTo;
    private Long staffId;
    private Integer floorArea;
    private String direction;
    private String level;
    private String type;


    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public Integer getBuildingArea() {
        return buildingArea;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getStreet() {
        return street;
    }

    public String getWard() {
        return ward;
    }

    public String getType() {
        return type;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public Integer getAreaRentFrom() {
        return areaRentFrom;
    }

    public Integer getAreaRentTo() {
        return areaRentTo;
    }


    public Integer getFloorArea() {
        return floorArea;
    }

    public String getDirection() {
        return direction;
    }


    public String getLevel() {
        return level;
    }


    public Long getStaffId() {
        return staffId;
    }

    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.district = builder.district;
        this.buildingArea = builder.buildingArea;
        this.numberOfBasement = builder.numberOfBasement;
        this.street = builder.street;
        this.ward = builder.ward;

        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.areaRentFrom = builder.areaRentFrom;
        this.areaRentTo = builder.areaRentTo;
        this.staffId = builder.staffId;
        this.floorArea = builder.floorArea;
        this.direction = builder.direction;
        this.level = builder.level;
        this.staffId = builder.staffId;
        this.type = builder.type;


    }

    public static class Builder {

        private String name;
        private String district;
        private String street;
        private String ward;
        private Integer buildingArea;
        private Integer numberOfBasement;

        private Integer rentPriceFrom;
        private Integer rentPriceTo;
        private Integer areaRentFrom;
        private Integer areaRentTo;
        private Long staffId;
        private Integer floorArea;
        private String direction;
        private String level;
        private String type;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setBuildingArea(Integer buildingArea) {
            this.buildingArea = buildingArea;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }


        public Builder setRentPriceFrom(Integer rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setRentPriceTo(Integer rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder setAreaRentFrom(Integer areaRentFrom) {
            this.areaRentFrom = areaRentFrom;
            return this;
        }

        public Builder setAreaRentTo(Integer areaRentTo) {
            this.areaRentTo = areaRentTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setType(String types) {
            this.type = types;
            return this;
        }


        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }


    }
}
