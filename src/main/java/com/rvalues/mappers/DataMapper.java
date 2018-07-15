package com.rvalues.mappers;

import com.rvalues.dtos.DataVO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataMapper {

    public static DataVO mapToDataVO(String line){

        DataVO dataVO = new DataVO();

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

        /* The below regex patterns will remove quotes and add
        *  the owner, location, and rValue to the data object.
        */
        String owner = matchList.get(0).replaceAll("^\"|\"$", "");
        dataVO.setOwner(owner);

        String location = matchList.get(1).replaceAll("^\"|\"$", "");
        dataVO.setLocation(location);

        dataVO.setRValue(Float.valueOf(matchList.get(2)));

        return dataVO;
    }
}
