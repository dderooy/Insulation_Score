package com.rvalues.mappers;

import com.rvalues.dtos.QueryVO;
import com.rvalues.mappers.QueryMapper;
import org.junit.Assert;
import org.junit.Test;

public class QueryMapperTest {

    QueryMapper queryMapper = new QueryMapper();
    String line1 = "\"John Doe\" \"Canada/Ontario/Toronto\"";
    String line2 = "\"John Doe\" \"Canada/Ontario\"";
    String line3 = "\"John Doe\" \"Canada\"";

    @Test
    public void testQueryReader(){
        QueryVO queryVO = queryMapper.mapToQueryVO(line1);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Toronto", queryVO.getRegion());

        queryVO = queryMapper.mapToQueryVO(line2);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Ontario", queryVO.getRegion());

        queryVO = queryMapper.mapToQueryVO(line3);
        Assert.assertNotNull(queryVO);
        Assert.assertEquals("John Doe", queryVO.getOwner());
        Assert.assertEquals("Canada", queryVO.getRegion());


    }


}
