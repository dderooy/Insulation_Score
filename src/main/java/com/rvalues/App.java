package com.rvalues;


import com.rvalues.dtos.DataDto;
import com.rvalues.dtos.QueryDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        ArrayList<DataDto> dataStack = new ArrayList<>();
        ArrayList<QueryDto> queryStack = new ArrayList<>();

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line = buff.readLine().trim();

        boolean queryFlag = false;

        while (line != null ){
            if(line.isEmpty()) {
                queryFlag = true;
                continue;
            }

            if(!queryFlag) {
                DataDto dataDto = DataReader.toHomeDto(line);
                dataStack.add(dataDto);
            }

            QueryDto queryDto = QueryReader.toQueryDto(line);
            queryStack.add(queryDto);
        }

        buff.close();

        for(QueryDto query : queryStack){
            query = RunQuery.getResult(query, dataStack);
            System.out.println("\"" + query.getOwner() + "\" \"" + query.getLocation() + "\"" + query.getRank());
        }



    }


}
