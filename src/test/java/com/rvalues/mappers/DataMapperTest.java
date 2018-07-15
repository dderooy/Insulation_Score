package com.rvalues.mappers;

import com.rvalues.dtos.DataVO;
import org.junit.Assert;
import org.junit.Test;

public class DataMapperTest {

    String line = "\"John Doe\" \"Canada/Ontario/Toronto\" 4.565";

    @Test
    public void testReader(){

       DataVO dataVO = DataMapper.mapToDataVO(line);

        Assert.assertNotNull(dataVO);
        Assert.assertEquals("John Doe", dataVO.getOwner());
        Assert.assertEquals("Canada/Ontario/Toronto", dataVO.getLocation());
        Assert.assertEquals(new Float(4.565f), Float.valueOf(dataVO.getRValue()));
    }
}
