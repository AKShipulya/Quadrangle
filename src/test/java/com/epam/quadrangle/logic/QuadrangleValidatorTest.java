package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleValidatorTest {

    @Test
    public void testIsValidShouldValidateParameters() {
        //given
        QuadrangleValidator validator = new QuadrangleValidator();
        Quadrangle quadrangle = new Quadrangle(new Point(10.0, 10.0), new Point(10.0, 40.0),
                                                new Point(60.0, 40.0), new Point(60.0, 10.0));
        //when
        boolean actual = validator.isValid(quadrangle);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsValidShouldNotValidateParameters() {
        //given
        QuadrangleValidator validator = new QuadrangleValidator();
        Quadrangle quadrangle = new Quadrangle(new Point(11.0, 10.0), new Point(10.0, 40.0),
                                                new Point(60.0, 40.0), new Point(60.0, 10.0));
        //when
        boolean actual = validator.isValid(quadrangle);
        //then
        Assert.assertFalse(actual);
    }

}