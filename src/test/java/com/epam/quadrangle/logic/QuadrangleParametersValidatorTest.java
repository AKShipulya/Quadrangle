package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadrangleParametersValidatorTest {

    @Test
    public void testIsQuadrangleValidShouldValidateParameters() {
        //given
        QuadrangleParametersValidator validator = new QuadrangleParametersValidator();
        Point pointA = new Point(10.0, 10.0);
        Point pointB = new Point(10.0, 40.0);
        Point pointC = new Point(60.0, 40.0);
        Point pointD = new Point(60.0, 10.0);
        //when
        boolean actual = validator.isQuadrangleValid(pointA, pointB, pointC, pointD);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsQuadrangleValidShouldNotValidateParameters() {
        //given
        QuadrangleParametersValidator validator = new QuadrangleParametersValidator();
        Point pointA = new Point(11.0, 10.0);
        Point pointB = new Point(10.0, 40.0);
        Point pointC = new Point(60.0, 40.0);
        Point pointD = new Point(60.0, 10.0);
        //when
        boolean actual = validator.isQuadrangleValid(pointA, pointB, pointC, pointD);
        //then
        Assert.assertFalse(actual);
    }

}