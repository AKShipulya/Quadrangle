package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrangleCreatorTest {

    @Test
    public void testCreateQuadrangleShouldCreateQuadrangle() throws QuadrangleException {
        //given
        List<Double> coordinatesPoints = Arrays.asList(10.0, 10.0, 10.0, 40.0, 60.0, 40.0, 60.0, 10.0);
        Quadrangle expected = new QuadrangleObservable(1L, new Point(10, 10), new Point(10, 40)
                , new Point(60, 40), new Point(60, 10));
        //when
        QuadrangleValidator VALIDATOR = new QuadrangleValidator();
        QuadrangleCreator creator = new QuadrangleCreator(VALIDATOR);
        Quadrangle actual = creator.createQuadrangle(coordinatesPoints);
        //then
        Assert.assertEquals(expected, actual);
    }
}