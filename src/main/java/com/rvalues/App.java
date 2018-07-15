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
    public static void main( String[] args ) {
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

        try {

            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String line;

            //Read each line from stdin, assign it to a string and trim whitespaces.
            while ((line = buff.readLine()) != null) {

                line = line.trim();

                //check for the empty line signifying the beginning of query input
                if (line.isEmpty()) {
                    queryFlag = true;
                    continue;
                }

                //map incoming data lines to DataVOs and add to data set
                if (!queryFlag) {
                    DataVO dataVO = DataMapper.mapToDataVO(line);
                    dataSet.add(dataVO);
                }

                //map incoming query lines to QueryVOs and add to query set
                if(queryFlag) {
                    QueryVO queryVO = QueryMapper.mapToQueryVO(line);
                    querySet.add(queryVO);
                }

            }

            buff.close();

        } catch (IOException io){
            io.printStackTrace();
        }

        /* For each query, get the owner rank for the desired region
        *  and output the result to stdout
        */
        for(QueryVO query : querySet){
            query = RunQuery.getResult(query, dataSet);
            System.out.println("\"" + query.getOwner() + "\" \"" + query.getLocation() + "\" " + query.getRank());
        }


    }


}
