package com.rvalues;

import com.rvalues.dtos.DataVO;
import com.rvalues.dtos.QueryVO;

import java.util.ArrayList;
import java.util.List;

public class RunQuery {

    public static QueryVO getResult(QueryVO queryVO, ArrayList<DataVO> dataStack){
        /* queryOwner is the customer we are finding a rank for,
        *  and queryRegion is the region they are being ranked in.
        */
        String queryOwner = queryVO.getOwner();
        String queryRegion = queryVO.getRegion();

        /* Since a query input line does not give us the rValue to
        *  check, we have to find it from the data set. This is the
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
        for(DataVO dataVO : dataStack){
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
        if((double) 90<= percentile && percentile < (double) 100)
            queryVO.setRank(1);
        if((double) 80<= percentile && percentile < (double) 90)
            queryVO.setRank(2);
        if((double) 70<= percentile && percentile < (double) 80)
            queryVO.setRank(3);
        if((double) 60<= percentile && percentile < (double) 70)
            queryVO.setRank(4);
        if((double) 50<= percentile && percentile < (double) 60)
            queryVO.setRank(5);
        if((double) 40<= percentile && percentile < (double) 50)
            queryVO.setRank(6);
        if((double) 30<= percentile && percentile < (double) 40)
            queryVO.setRank(7);
        if((double) 20<= percentile && percentile < (double) 30)
            queryVO.setRank(8);
        if((double) 10<= percentile && percentile < (double) 20)
            queryVO.setRank(9);
        if((double) 0<= percentile && percentile < (double) 10)
            queryVO.setRank(10);

        return queryVO;
    }


}
