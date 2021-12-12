package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

public class QuadrangleCalculatorTest {
    private final QuadrangleCalculator CALCULATOR = new QuadrangleCalculator();
    private static final QuadrangleObservable QUADRANGLE = new QuadrangleObservable(1L, new Point(10.0, 10.0),
            new Point(10.0, 40.0), new Point(60.0, 40.0), new Point(60.0, 10.0));


    @Test
    public void testCalculateQuadrangleAreaShouldReturnsValidValue() throws QuadrangleException {
        //given
        double expected = 1500.0;
        //when
        double actual = CALCULATOR.calculateQuadrangleArea(QUADRANGLE);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCalculateQuadranglePerimeterShouldReturnsValidValue() throws QuadrangleException {
        //given
        double expected = 160.00;
        //when
        double actual = CALCULATOR.calculateQuadranglePerimeter(QUADRANGLE);
        //then
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testIsRegularRectangleShouldReturnTrueIfShapeRegularRectangle() throws QuadrangleException {
        //given
        //when
        boolean actual = CALCULATOR.isRegularRectangle(QUADRANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRegularRectangleShouldReturnFalseIfShapeIrregularRectangle() throws QuadrangleException {
        //given
        QuadrangleObservable irregularQuadrangle = new QuadrangleObservable(1L, new Point(10, 10),
                new Point(15, 40), new Point(35, 40), new Point(40, 10));
        //when
        boolean actual = CALCULATOR.isRegularRectangle(irregularQuadrangle);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testArePointsLocationAtOneLineShouldReturnTrueWhenPointsNotAtLine() throws QuadrangleException {
        //given
        //when
        boolean actual = CALCULATOR.arePointsLocationAtOneLine(QUADRANGLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSquareShouldReturnTrueIfQuadrangleIsSquare() throws QuadrangleException {
        //given
        QuadrangleObservable square = new QuadrangleObservable(1L, new Point(10, 10),
                new Point(10, 40), new Point(40, 40), new Point(40, 10));
        //when
        boolean actual = CALCULATOR.isSquare(square);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsTrapezoidShouldReturnTrueIfQuadrangleTrapezoid() throws QuadrangleException {
        //given
        QuadrangleObservable trapezoid = new QuadrangleObservable(1L, new Point(10.0, 10.0),
                new Point(20.0, 40.0), new Point(50.0, 40.0), new Point(60.0, 10.0));
        //when
        boolean actual = CALCULATOR.isTrapezoid(trapezoid);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRhombusShouldReturnTrueIfQuadrangleIsRhombus() throws QuadrangleException {
        //given
        QuadrangleObservable rhombus = new QuadrangleObservable(1L, new Point(50.0, 10.0),
                new Point(10.0, 50.0), new Point(50.0, 90.0), new Point(90.0, 50.0));
        //when
        boolean actual = CALCULATOR.isRhombus(rhombus);
        //then
        Assert.assertTrue(actual);
    }
}