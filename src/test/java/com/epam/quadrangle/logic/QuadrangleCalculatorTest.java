package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrangleCalculatorTest {
    private final QuadrangleCreator CREATOR = new QuadrangleCreator();
    private final QuadrangleCalculator CALCULATOR = new QuadrangleCalculator();
    private static final List<Double> COORDINATES_POINTS =
            Arrays.asList(10.0, 10.0, 10.0, 40.0, 60.0, 40.0, 60.0, 10.0);
    private static final List<Double> SQUARE_COORDINATES_POINTS =
            Arrays.asList(10.0, 10.0, 10.0, 40.0, 40.0, 40.0, 40.0, 10.0);

    @Test
    public void testCalculateQuadrangleAreaShouldReturnsValidValue() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = CREATOR.createQuadrangle(COORDINATES_POINTS);
        double expected = 1500.0;
        //when
        double actual = CALCULATOR.calculateQuadrangleArea(Quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCalculateQuadranglePerimeterShouldReturnsValidValue() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = CREATOR.createQuadrangle(COORDINATES_POINTS);
        double expected = 160.00;
        //when
        double actual = CALCULATOR.calculateQuadranglePerimeter(Quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void ifQuadrangleIsSquare() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = CREATOR.createQuadrangle(SQUARE_COORDINATES_POINTS);
        //when
        boolean actual = CALCULATOR.isSquare(Quadrangle);
        //then
        Assert.assertTrue(actual);

    }
}