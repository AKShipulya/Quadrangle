package com.epam.quadrangle.logic;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.data.QuadrangleLineValidator;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleCalculatorTest {
    private final QuadrangleValidator VALIDATOR = new QuadrangleValidator();
    private final QuadrangleLineValidator LINE_VALIDATOR = new QuadrangleLineValidator();
    private final DataLinesParser PARSER = new DataLinesParser(LINE_VALIDATOR);
    private final QuadrangleCreator CREATOR = new QuadrangleCreator(VALIDATOR, PARSER);
    private final QuadrangleCalculator CALCULATOR = new QuadrangleCalculator();

    private static final String RECTANGLE_COORDINATES_POINTS = "10.0 10.0 10.0 40.0 60.0 40.0 60.0 10.0";



    @Test
    public void testCalculateQuadrangleAreaShouldReturnsValidValue() throws QuadrangleException, DataException {
        //given
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(RECTANGLE_COORDINATES_POINTS);
        double expected = 1500.0;
        //when
        double actual = CALCULATOR.calculateQuadrangleArea(quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCalculateQuadranglePerimeterShouldReturnsValidValue() throws QuadrangleException, DataException {
        //given
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(RECTANGLE_COORDINATES_POINTS);
        double expected = 160.00;
        //when
        double actual = CALCULATOR.calculateQuadranglePerimeter(quadrangle);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testIsSquareShouldReturnTrueIfShapeSquare() throws QuadrangleException, DataException {
        //given
        String squareCoordinatesPoints = "10.0 10.0 10.0 40.0 40.0 40.0 40.0 10.0";
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(squareCoordinatesPoints);
        //when
        boolean actual = CALCULATOR.isSquare(quadrangle);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRegularRectangleShouldReturnTrueIfShapeRectangle() throws QuadrangleException, DataException {
        //given
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(RECTANGLE_COORDINATES_POINTS);
        //when
        boolean actual = CALCULATOR.isRegularRectangle(quadrangle);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRegularRectangleShouldReturnFalseIfShapeIrregularRectangle() throws QuadrangleException, DataException {
        //given
        String irregularRectangleCoordinatesPoints = "10.0 10.0 15.0 40.0 35.0 40.0 40.0 10.0";
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(irregularRectangleCoordinatesPoints);
        //when
        boolean actual = CALCULATOR.isRegularRectangle(quadrangle);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testArePointsLocationAtOneLineShouldReturnTrueWhenPointsNotAtLine() throws QuadrangleException, DataException {
        //given
        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(RECTANGLE_COORDINATES_POINTS);
        //when
        boolean actual = CALCULATOR.arePointsLocationAtOneLine(quadrangle);
        //then
        Assert.assertTrue(actual);
    }

    // FIXME: 07.12.2021
//    @Test
//    public void testArePointsLocationAtOneLineShouldReturnFalseWhenPointsAtLine() throws QuadrangleException, DataException {
//        //given
//        String squareCoordinatesPoints = "10.0 10.0 10.0 40.0 10.0 15.0 40.0 10.0";
//        QuadrangleObservable quadrangle = CREATOR.createQuadrangle(squareCoordinatesPoints);
//        //when
//        boolean actual = CALCULATOR.arePointsLocationAtOneLine(quadrangle);
//        //then
//        Assert.assertFalse(actual);
//    }
}