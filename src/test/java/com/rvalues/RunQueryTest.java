package com.rvalues;

import com.rvalues.dtos.DataDto;
import com.rvalues.dtos.QueryDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RunQueryTest {

    @Test
    public void testRunQuery(){
        QueryDto queryDto = new QueryDto();
        queryDto.setOwner("John Doe");
        queryDto.setRegion("Canada");
        queryDto = RunQuery.getResult(queryDto, createDataStack());
        Assert.assertNotNull(queryDto);
        Assert.assertEquals((Integer) 4, queryDto.getRank());

        queryDto.setOwner("John Doe");
        queryDto.setRegion("Ontario");
        queryDto = RunQuery.getResult(queryDto, createDataStack());
        Assert.assertNotNull(queryDto);
        Assert.assertEquals((Integer) 5, queryDto.getRank());

        queryDto.setOwner("Alicia Yazzie");
        queryDto.setRegion("Arizona");
        queryDto = RunQuery.getResult(queryDto, createDataStack());
        Assert.assertNotNull(queryDto);
        Assert.assertEquals((Integer) 10, queryDto.getRank());
    }

    private ArrayList<DataDto> createDataStack(){
        DataDto dataDto1 = new DataDto();
        dataDto1.setOwner("John Doe");
        dataDto1.setLocation("Canada/Ontario/Toronto");
        dataDto1.setRValue(new Float(1.5));

        DataDto dataDto2 =new DataDto();
        dataDto2.setOwner("Samantha Smith");
        dataDto2.setLocation("Canada/Ontario/London");
        dataDto2.setRValue(new Float(3.7));

        DataDto dataDto3 = new DataDto();
        dataDto3.setOwner("Adam Xin");
        dataDto3.setLocation("Canada/British Colombia/Vancouver");
        dataDto3.setRValue(new Float(2.110));

        DataDto dataDto4 = new DataDto();
        dataDto4.setOwner("Monica Taylor");
        dataDto4.setLocation("Canada/Ontario/Toronto");
        dataDto4.setRValue(new Float(2.110));

        DataDto dataDto5 = new DataDto();
        dataDto5.setOwner("Alicia Yazzie");
        dataDto5.setLocation("US/Arizona/Phoenix");
        dataDto5.setRValue(new Float(5.532));

        DataDto dataDto6 = new DataDto();
        dataDto6.setOwner("Mohammad Zadeh");
        dataDto6.setLocation("Canada/Ontario/Toronto");
        dataDto6.setRValue(new Float(1.43));

        ArrayList<DataDto> dataStack = new ArrayList<>();
        dataStack.add(dataDto1);
        dataStack.add(dataDto2);
        dataStack.add(dataDto3);
        dataStack.add(dataDto4);
        dataStack.add(dataDto5);
        dataStack.add(dataDto6);

        return dataStack;
    }

}
