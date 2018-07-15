package com.rvalues;

import com.rvalues.dtos.DataVO;
import com.rvalues.dtos.QueryVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RunQueryTest {

    @Test
    public void testRunQuery(){
        QueryVO queryVO = new QueryVO();
        queryVO.setOwner("John Doe");
        queryVO.setRegion("Canada");
        queryVO = RunQuery.getResult(queryVO, createDataStack());
        Assert.assertNotNull(queryVO);
        Assert.assertEquals((Integer) 4, queryVO.getRank());

        queryVO.setOwner("John Doe");
        queryVO.setRegion("Ontario");
        queryVO = RunQuery.getResult(queryVO, createDataStack());
        Assert.assertNotNull(queryVO);
        Assert.assertEquals((Integer) 5, queryVO.getRank());

        queryVO.setOwner("Alicia Yazzie");
        queryVO.setRegion("Arizona");
        queryVO = RunQuery.getResult(queryVO, createDataStack());
        Assert.assertNotNull(queryVO);
        Assert.assertEquals((Integer) 10, queryVO.getRank());
    }

    private ArrayList<DataVO> createDataStack(){
        DataVO dataVO1 = new DataVO();
        dataVO1.setOwner("John Doe");
        dataVO1.setLocation("Canada/Ontario/Toronto");
        dataVO1.setRValue(new Float(1.5));

        DataVO dataVO2 =new DataVO();
        dataVO2.setOwner("Samantha Smith");
        dataVO2.setLocation("Canada/Ontario/London");
        dataVO2.setRValue(new Float(3.7));

        DataVO dataVO3 = new DataVO();
        dataVO3.setOwner("Adam Xin");
        dataVO3.setLocation("Canada/British Colombia/Vancouver");
        dataVO3.setRValue(new Float(2.110));

        DataVO dataVO4 = new DataVO();
        dataVO4.setOwner("Monica Taylor");
        dataVO4.setLocation("Canada/Ontario/Toronto");
        dataVO4.setRValue(new Float(2.110));

        DataVO dataVO5 = new DataVO();
        dataVO5.setOwner("Alicia Yazzie");
        dataVO5.setLocation("US/Arizona/Phoenix");
        dataVO5.setRValue(new Float(5.532));

        DataVO dataVO6 = new DataVO();
        dataVO6.setOwner("Mohammad Zadeh");
        dataVO6.setLocation("Canada/Ontario/Toronto");
        dataVO6.setRValue(new Float(1.43));

        ArrayList<DataVO> dataStack = new ArrayList<>();
        dataStack.add(dataVO1);
        dataStack.add(dataVO2);
        dataStack.add(dataVO3);
        dataStack.add(dataVO4);
        dataStack.add(dataVO5);
        dataStack.add(dataVO6);

        return dataStack;
    }

}
