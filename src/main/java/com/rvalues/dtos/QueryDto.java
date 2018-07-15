package com.rvalues.dtos;

public class QueryDto {
    private String owner;
    private String location;
    private String region;
    private int rank;

    public String getOwner(){return owner;}
    public void setOwner(String owner){this.owner=owner;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}

    public String getRegion(){return region;}
    public void setRegion(String region){this.region=region;}

    public Integer getRank(){return rank;}
    public void setRank(int rank){this.rank=rank;}
}
