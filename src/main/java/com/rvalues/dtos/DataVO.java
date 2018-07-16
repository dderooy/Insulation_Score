package com.rvalues.dtos;

public class DataVO {
    private String owner;
    private String location;
    private float rValue;

    public String getOwner(){return owner;}
    public void setOwner(String owner){this.owner=owner;}

    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}

    public float getRValue(){return rValue;}
    public void setRValue(float rValue){this.rValue=rValue;}

    @Override
    public boolean equals (Object obj){
        if(obj instanceof DataVO){
            DataVO dataVO = (DataVO) obj;

            if(owner.equals(dataVO.getOwner())
                    && location.equals(dataVO.getLocation()))
                return true;
        }

        return false;
    }

    @Override
    public int hashCode(){
        int hash = 3;
        hash = 7 * hash + this.owner.hashCode() + this.location.hashCode();

        return hash;
    }


}
