package com.rvalues;

import com.rvalues.dtos.DataVO;
import com.rvalues.dtos.QueryVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RunQuery {

    public static QueryVO getResult(QueryVO queryVO, HashSet<DataVO> dataSet){
        /* queryOwner is the customer we are finding a rank for,
        *  and queryRegion is the region they are being ranked in.
        */
        String queryOwner = queryVO.getOwner();
        String queryRegion = queryVO.getRegion();

        /* Since a query input line does not give us the rValue to
        *  check, we have to find it from the data set. queryRValue is the
        *  customer's rValue we are finding a rank for.
        */
        Float queryRValue = 0f;

        /* regionRValues represents to set of rValues we are comparing the
        *  customer rValue against
        */
        List<Float> regionRValues = new ArrayList<>();

        /* This for loop iterates through the data stack and collects all the
        *  relevant region rValues for the given query. It also grabs the customer
        *  queryRValue in question.
        */
        for(DataVO dataVO : dataSet){
            if(dataVO.getLocation().toLowerCase().contains(queryRegion.toLowerCase()))
                regionRValues.add(dataVO.getRValue());

            if(dataVO.getOwner().toLowerCase().equals(queryOwner.toLowerCase()))
                queryRValue = dataVO.getRValue();
        }

        /* betterRValues represents all the homes with better rValues than
        *  the home in question.
        */
        int betterRValues = 0;

        //Find all the homes with better rValues than the query value
        for(Float rValue : regionRValues){
            if(rValue > queryRValue)
                betterRValues++;
        }

        /* percentile represents the percentage of homes with better rValues for
        *  the given query region.
        */
        double percentile = (double) betterRValues / (double) regionRValues.size();
        percentile = percentile * (double) 100;

        /* The last step is to find the query rank given the percentage of homes with
        *  better rValues
        */
        queryVO.setRank((int) Math.ceil((100 - percentile) / 10.0));

        return queryVO;
    }


}
