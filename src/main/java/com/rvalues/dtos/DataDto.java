package com.rvalues.dtos;

public class DataDto {
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

    public String getCountry(){return country;}
    public void setCountry(String country){this.country=country;}

    public String getState(){return state;}
    public void setState(String state){this.state=state;}

    public String getCity(){return city;}
    public void setCity(String city){this.city=city;}

    public float getRValue(){return rValue;}
    public void setRValue(float rValue){this.rValue=rValue;}

}
