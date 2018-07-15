package com.rvalues.mappers;

import com.rvalues.dtos.QueryVO;
import org.junit.Assert;
import org.junit.Test;

public class QueryMapperTest {

    String line1 = "\"John Doe\" \"Canada/Ontario/Toronto\"";
    String line2 = "\"John Doe\" \"Canada/Ontario\"";
    String line3 = "\"John Doe\" \"Canada\"";

    @Test
    public void testQueryReader(){
        QueryVO queryVO = QueryMapper.mapToQueryVO(line1);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Toronto", queryVO.getRegion());

        queryVO = QueryMapper.mapToQueryVO(line2);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Ontario", queryVO.getRegion());

        queryVO = QueryMapper.mapToQueryVO(line3);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Canada", queryVO.getRegion());


    }


}
