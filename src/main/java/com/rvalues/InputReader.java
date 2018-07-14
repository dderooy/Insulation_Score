package com.rvalues;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {

    public HomeDto toHomeDto(String line){
        HomeDto homeDto = new HomeDto();

        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"[^\"]*\"|'[^']*'");
        Matcher regexMatcher = regex.matcher(line);

        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        String owner = matchList.get(0).replaceAll("^\"|\"$", "");
        homeDto.setOwner(owner);

        String location = matchList.get(1).replaceAll("^\"|\"$", "");
        String[] regions = location.split("/");
        homeDto.setCountry(regions[0]);
        homeDto.setState(regions[1]);
        homeDto.setCity(regions[2]);

        homeDto.setRValue(Float.valueOf(matchList.get(2)));

        return homeDto;
    }
}
