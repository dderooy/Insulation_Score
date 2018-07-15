package com.rvalues;

import com.rvalues.dtos.QueryDto;
import org.junit.Assert;
import org.junit.Test;

public class QueryReaderTest {

    QueryReader queryReader = new QueryReader();
    String line1 = "\"John Doe\" \"Canada/Ontario/Toronto\"";
    String line2 = "\"John Doe\" \"Canada/Ontario\"";
    String line3 = "\"John Doe\" \"Canada\"";

    @Test
    public void testQueryReader(){
        QueryDto queryDto = queryReader.toQueryDto(line1);
        Assert.assertNotNull(queryDto);
        Assert.assertEquals("John Doe", queryDto.getOwner());
        Assert.assertEquals("Toronto", queryDto.getRegion());

        queryDto = queryReader.toQueryDto(line2);
        Assert.assertNotNull(queryDto);
        Assert.assertEquals("John Doe", queryDto.getOwner());
        Assert.assertEquals("Ontario", queryDto.getRegion());

        queryDto = queryReader.toQueryDto(line3);
        Assert.assertNotNull(queryDto);
        Assert.assertEquals("John Doe", queryDto.getOwner());
        Assert.assertEquals("Canada", queryDto.getRegion());


    }


}
