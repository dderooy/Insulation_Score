package com.rvalues;

import com.rvalues.dtos.DataDto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {

    public static DataDto toHomeDto(String line){
        DataDto dataDto = new DataDto();

        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(line);

        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        String owner = matchList.get(0).replaceAll("^\"|\"$", "");
        dataDto.setOwner(owner);

        String location = matchList.get(1).replaceAll("^\"|\"$", "");
        dataDto.setLocation(location);
        String[] regions = location.split("/");
        dataDto.setCountry(regions[0]);
        dataDto.setState(regions[1]);
        dataDto.setCity(regions[2]);

        dataDto.setRValue(Float.valueOf(matchList.get(2)));

        return dataDto;
    }
}
