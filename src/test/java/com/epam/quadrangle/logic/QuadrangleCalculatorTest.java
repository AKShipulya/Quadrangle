package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCalculatorTest {
    private final QuadrangleCreator quadrangleCreator = QuadrangleCreator.getInstance();
    private final QuadrangleCalculator quadrangleCalculator = new QuadrangleCalculator();
    private List<Double> coordinatesPoints;
    private List<Double> SquareCoordinatesPoints;

    @Before
    public void setUp() {
        coordinatesPoints = new ArrayList<>();
        coordinatesPoints.add(10.0);
        coordinatesPoints.add(10.0);
        coordinatesPoints.add(10.0);
        coordinatesPoints.add(40.0);
        coordinatesPoints.add(60.0);
        coordinatesPoints.add(40.0);
        coordinatesPoints.add(60.0);
        coordinatesPoints.add(10.0);

        SquareCoordinatesPoints = new ArrayList<>();
        SquareCoordinatesPoints.add(10.0);
        SquareCoordinatesPoints.add(10.0);
        SquareCoordinatesPoints.add(10.0);
        SquareCoordinatesPoints.add(40.0);
        SquareCoordinatesPoints.add(40.0);
        SquareCoordinatesPoints.add(40.0);
        SquareCoordinatesPoints.add(40.0);
        SquareCoordinatesPoints.add(10.0);
    }

    @Test
    public void testCalculateQuadrangleAreaShouldReturnsValidValue() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = quadrangleCreator.createQuadrangle(coordinatesPoints);
        double expected = 1500.0;
        //when
        double actual = quadrangleCalculator.calculateQuadrangleArea(Quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCalculateQuadranglePerimeterShouldReturnsValidValue() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = quadrangleCreator.createQuadrangle(coordinatesPoints);
        double expected = 160.00;
        //when
        double actual = quadrangleCalculator.calculateQuadranglePerimeter(Quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void ifQuadrangleIsSquare() throws QuadrangleException {
        //given
        Quadrangle Quadrangle = quadrangleCreator.createQuadrangle(SquareCoordinatesPoints);
        //when
        boolean actual = quadrangleCalculator.isSquare(Quadrangle);
        //then
        Assert.assertTrue(actual);

    }
}