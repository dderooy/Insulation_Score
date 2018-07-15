package com.rvalues;

import com.rvalues.dtos.DataDto;
import com.rvalues.dtos.QueryDto;

import java.util.ArrayList;
import java.util.List;

public class RunQuery {

    public static QueryDto getResult(QueryDto queryDto, ArrayList<DataDto> dataStack){
        String querOwner = queryDto.getOwner();
        String queryRegion = queryDto.getRegion();
        Float rValueToCheck = 0f;
        List<Float> regionRValues = new ArrayList<>();

        for(DataDto dataDto : dataStack){
            if(dataDto.getLocation().toLowerCase().contains(queryRegion.toLowerCase()))
                regionRValues.add(dataDto.getRValue());

            if(dataDto.getOwner().toLowerCase().equals(querOwner.toLowerCase()))
                rValueToCheck = dataDto.getRValue();
        }

        int betterRValues = 0;

        for(Float rValue : regionRValues){
            if(rValue > rValueToCheck)
                betterRValues++;
        }

        double percentile = (double) betterRValues / (double) regionRValues.size();
        percentile = percentile * (double) 100;

        if((double) 90<= percentile && percentile < (double) 100)
            queryDto.setRank(1);
        if((double) 80<= percentile && percentile < (double) 90)
            queryDto.setRank(2);
        if((double) 70<= percentile && percentile < (double) 80)
            queryDto.setRank(3);
        if((double) 60<= percentile && percentile < (double) 70)
            queryDto.setRank(4);
        if((double) 50<= percentile && percentile < (double) 60)
            queryDto.setRank(5);
        if((double) 40<= percentile && percentile < (double) 50)
            queryDto.setRank(6);
        if((double) 30<= percentile && percentile < (double) 40)
            queryDto.setRank(7);
        if((double) 20<= percentile && percentile < (double) 30)
            queryDto.setRank(8);
        if((double) 10<= percentile && percentile < (double) 20)
            queryDto.setRank(9);
        if((double) 0<= percentile && percentile < (double) 10)
            queryDto.setRank(10);

        return queryDto;
    }


}
