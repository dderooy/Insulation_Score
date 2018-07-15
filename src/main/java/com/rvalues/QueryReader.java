package com.rvalues;

import com.rvalues.dtos.QueryDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryReader {

    public static QueryDto toQueryDto(String line){
        QueryDto queryDto = new QueryDto();

        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(line);

        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        String owner = matchList.get(0).replaceAll("^\"|\"$", "");
        queryDto.setOwner(owner);

        String location = matchList.get(1).replaceAll("^\"|\"$", "");
        queryDto.setLocation(location);
        queryDto.setRegion(location.substring(location.lastIndexOf("/") +1));

        return queryDto;
    }

}
