package com.rvalues;


import com.rvalues.dtos.DataVO;
import com.rvalues.dtos.QueryVO;
import com.rvalues.mappers.DataMapper;
import com.rvalues.mappers.QueryMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        /* The data set is where each line of data input will be stored
        *  in a DataVO. This acts as the in code 'data base'. Similarily the
        *  query set stores all the input queries. HashSet was the chosen data
        *  structure to prevent duplicate data and allow for fast performance.
        */
        HashSet<DataVO> dataSet = new HashSet<>();
        HashSet<QueryVO> querySet = new HashSet<>();

        /* If the query flag is false, each line of stdin will be converted to a
         * DataVO. If set true, stdin lines convert to QueryVOs.
         */
        boolean queryFlag = false;

        //Read each line from stdin, assign it to a string and trim whitespaces.
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String line = buff.readLine().trim();

        while (line != null ){
            //check for end of data input
            if(line.isEmpty()) {
                queryFlag = true;
                continue;
            }

            //map incoming data lines to DataVOs and add to data set
            if(!queryFlag) {
                DataVO dataVO = DataMapper.mapToDataVO(line);
                dataSet.add(dataVO);
            }

            //map incoming query lines to QueryVOs and add to query set
            QueryVO queryVO = QueryMapper.mapToQueryVO(line);
            querySet.add(queryVO);
        }

        buff.close();

        /* For each query, get the owner rank for the desired region
        *  and output the result to stdout
        */
        for(QueryVO query : querySet){
            query = RunQuery.getResult(query, dataSet);
            System.out.println("\"" + query.getOwner() + "\" \"" + query.getLocation() + "\"" + query.getRank());
        }



    }


}
