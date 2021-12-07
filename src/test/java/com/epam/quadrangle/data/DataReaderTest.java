package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testReadValidLinesFromFileShouldReadValidLines() throws DataException, IOException {
        //given
        DataReader reader = new DataReader();
        String filePath = "src/test/resources/testCoordinates.txt";
        List<String> expected = Arrays.asList("10.0 10.0 10.0 40.0 60.0 40.0 60.0 10.0",
                "10.0 10.0 10.0 40.0 40.0 40.0 40.0 10.0");
        //when
        List<String> actual = reader.readValidLinesFromFile(filePath);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IOException.class)
    public void testReadValidLinesFromFileShouldNotReadLines() throws DataException, IOException {
        //given
        DataReader reader = new DataReader();
        String filePath = "/1/1/1.tst";
        //when
        reader.readValidLinesFromFile(filePath);
    }
}