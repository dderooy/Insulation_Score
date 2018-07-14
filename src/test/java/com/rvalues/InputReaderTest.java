package com.rvalues;

import org.junit.Assert;
import org.junit.Test;

public class InputReaderTest {

    InputReader inputReader = new InputReader();

    String line = "\"John Doe\" \"Canada/Ontario/Toronto\" 4.565";

    @Test
    public void testReader(){

       HomeDto homeDto = inputReader.toHomeDto(line);

        Assert.assertNotNull(homeDto);




    }
}
