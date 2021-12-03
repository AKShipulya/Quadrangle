package com.epam.quadrangle.data;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadrangleLineValidatorTest {

    @Test
    public void testIsValidShouldValidateLine() {
        //given
        String line = "10.0 11.0 12.0 13.0 14.0 15.0 16.0 17.0";
        //when
        boolean actual = QuadrangleLineValidator.isValid(line);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldNotValidateLine() {
        //given
        String line = "10.0 11.0 12.0 13.f 14.0 15.0 16.0 17.0";
        //when
        boolean actual = QuadrangleLineValidator.isValid(line);
        //then
        Assert.assertFalse(actual);
    }

}