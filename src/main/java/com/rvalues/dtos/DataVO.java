package com.rvalues.dtos;

public class DataVO {
    private String owner;
    private String location;
    private String country;
    private String state;
    private String city;
    private float rValue;

    public String getOwner(){return owner;}
    public void setOwner(String owner){this.owner=owner;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}

    public float getRValue(){return rValue;}
    public void setRValue(float rValue){this.rValue=rValue;}

}
