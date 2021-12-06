package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleValidatorTest {

    @Test
    public void testIsValidShouldValidateParameters() {
        //given
        QuadrangleValidator validator = new QuadrangleValidator();
        QuadrangleObservable quadrangle = new QuadrangleObservable(1L, new Point(10.0, 10.0), new Point(10.0, 40.0),
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
        QuadrangleObservable quadrangle = new QuadrangleObservable(1L, new Point(10.0, 10.0), new Point(10.0, 40.0),
                new Point(10.0, 40.0), new Point(60.0, 10.0));
        //when
        boolean actual = validator.isValid(quadrangle);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testIsValidShouldNotValidateNullParameters() {
        //given
        QuadrangleValidator validator = new QuadrangleValidator();
        QuadrangleObservable quadrangle = new QuadrangleObservable(1L, null, null, null, null);
        //when
        boolean actual = validator.isValid(quadrangle);
        //then
        Assert.assertFalse(actual);
    }
}