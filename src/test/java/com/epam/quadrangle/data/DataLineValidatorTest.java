package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class DataLineValidatorTest {

    @Test
    public void testIsValidShouldValidateLine() throws DataException {
        //given
        String line = "10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0";
        DataLineValidator validator = new DataLineValidator();
        //when
        boolean actual = validator.isValid(line);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldNotValidateLine() throws DataException {
        //given
        String line = "10.0 11.0 12.0 13.f 14.0 15.0 16.0 17.0";
        DataLineValidator validator = new DataLineValidator();
        //when
        boolean actual = validator.isValid(line);
        //then
        Assert.assertFalse(actual);
    }

}