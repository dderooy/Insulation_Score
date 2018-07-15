package com.rvalues.mappers;

import com.rvalues.dtos.QueryVO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMapper {

    public static QueryVO mapToQueryVO(String line){
        QueryVO queryVO = new QueryVO();

        /* The below regex pattern will split a data line by spaces,
         *  ignoring spaces between quotes. The results are added to
         *  a match list.
         */
        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(line);

        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        /* The below regex patterns will remove surrounding quotes
        *  and then add the owner, location, and specific region to
        *  the query object
        */
        String owner = matchList.get(0).replaceAll("^\"|\"$", "");
        queryVO.setOwner(owner);

        String location = matchList.get(1).replaceAll("^\"|\"$", "");
        queryVO.setLocation(location);
        queryVO.setRegion(location.substring(location.lastIndexOf("/") +1));

        return queryVO;
    }

}
