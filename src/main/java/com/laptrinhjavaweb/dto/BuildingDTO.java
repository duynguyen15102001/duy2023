package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {

    private String name;
    private String street;
    private String ward;

    private Integer floorArea;
    private Integer numberOfBasement;
    private Long staffId;
    private Map<Long, String> buildinhDTOs = new HashMap<>();
    private List<UserDTO> users = new ArrayList<>();
    private String userName;
    private String direct;
    private Integer areaRentFrom;
    private Integer areaRentTo;
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private List<String> rentTypes;
    private String rentArea;
    private String structure;
    private String direction;
    private String level;
    private String description;
    private String serviceFee;
    private String carFee;
    private String motoFee;
    private String overtimeFee;
    private String deposit;
    private String payment;
    private String decorationTime;
    private String manageName;
    private String managePhone;
    private String brokerageTee;
    private String note;
    private String types;
    private String district;
    private String image;
    private Integer rentPrice;

    private List<String> type;


    private String imageBase64;

    private String imageName;

    private String address;

    public String getImageBase64() {
        if (imageBase64 != null) {
            return imageBase64.split(",")[1];
        }
        return null;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;

    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Integer rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Integer rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public Map<Long, String> getBuildinhDTOs() {
        return buildinhDTOs;
    }

    public void setBuildinhDTOs(Map<Long, String> buildinhDTOs) {
        this.buildinhDTOs = buildinhDTOs;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }


    public Integer getAreaRentFrom() {
        return areaRentFrom;
    }

    public void setAreaRentFrom(Integer areaRentFrom) {
        this.areaRentFrom = areaRentFrom;
    }

    public Integer getAreaRentTo() {
        return areaRentTo;
    }

    public void setAreaRentTo(Integer areaRentTo) {
        this.areaRentTo = areaRentTo;
    }


    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public List<String> getRentTypes() {
        return rentTypes;
    }

    public void setRentTypes(List<String> rentTypes) {
        this.rentTypes = rentTypes;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotoFee() {
        return motoFee;
    }

    public void setMotoFee(String motoFee) {
        this.motoFee = motoFee;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public String getManagePhone() {
        return managePhone;
    }

    public void setManagePhone(String managePhone) {
        this.managePhone = managePhone;
    }

    public String getBrokerageTee() {
        return brokerageTee;
    }

    public void setBrokerageTee(String brokerageTee) {
        this.brokerageTee = brokerageTee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }
}
