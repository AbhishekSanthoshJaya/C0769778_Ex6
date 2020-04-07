package com.aby.c0769778_ex6.model;

public class CanadaAttractions {

    private String id;
    private String name;
    private String address;
    private String city;
    private String province;
    private String description;
    private int attractionImg;

    public CanadaAttractions(String id, String name, String address, String city, String province, String description, int attractionImg) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.description = description;
        this.attractionImg = attractionImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttractionImg() {
        return attractionImg;
    }

    public void setAttractionImg(int attractionImg) {
        this.attractionImg = attractionImg;
    }
}
