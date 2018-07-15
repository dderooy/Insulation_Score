package com.rvalues;

import com.rvalues.dtos.DataDto;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {

    DataReader dataReader = new DataReader();

    String line = "\"John Doe\" \"Canada/Ontario/Toronto\" 4.565";

    @Test
    public void testReader(){

       DataDto dataDto = dataReader.toHomeDto(line);

        Assert.assertNotNull(dataDto);
        Assert.assertEquals("John Doe", dataDto.getOwner());
        Assert.assertEquals("Canada", dataDto.getCountry());
        Assert.assertEquals("Ontario", dataDto.getState());
        Assert.assertEquals("Toronto", dataDto.getCity());
        Assert.assertEquals(new Float(4.565f), Float.valueOf(dataDto.getRValue()));
    }
}
