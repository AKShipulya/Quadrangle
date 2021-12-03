package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataLinesParserTest {

    @Test
    public void testParseToCoordinatesShouldReturnValidData() throws DataException {
        //given
        DataLinesParser parser = new DataLinesParser();
        String testLine = "10.0 10.0 10.0 40.0 60.0 40.0 60.0 10.0";
        List<Double> expected = Arrays.asList(10.0, 10.0, 10.0, 40.0, 60.0, 40.0, 60.0, 10.0);
        //when
        List<Double> actual = parser.parseToCoordinates(testLine);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = DataException.class)
    public void testParseToCoordinatesShouldNotParseInvalidLine() throws DataException {
        //given
        DataLinesParser parser = new DataLinesParser();
        String testLine = "10.0 10.0 10.0 40.0 60.0 4f.0 60.0 10.0";
        //when
        parser.parseToCoordinates(testLine);
    }
}