package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleCalculator {
    private static final Logger LOGGER = LogManager.getLogger();

    public double calculateQuadrangleArea(Quadrangle Quadrangle) throws QuadrangleException {
        if (Quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = Quadrangle.getPointA();
        Point pointB = Quadrangle.getPointB();
        Point pointC = Quadrangle.getPointC();
        double ab, bc;
        double result;

        ab = Math.sqrt(Math.pow(pointB.getPointX() - pointA.getPointX(), 2) + Math.pow(pointB.getPointY() - pointA.getPointY(), 2));
        bc = Math.sqrt(Math.pow(pointC.getPointX() - pointB.getPointX(), 2) + Math.pow(pointC.getPointY() - pointB.getPointY(), 2));

        result = ab * bc;
        LOGGER.info("Quadrangle calculated area is: {}", result);
        return result;
    }

    public double calculateQuadranglePerimeter(Quadrangle Quadrangle) throws QuadrangleException {
        if (Quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = Quadrangle.getPointA();
        Point pointB = Quadrangle.getPointB();
        Point pointC = Quadrangle.getPointC();
        double ab, bc;
        double result;

        ab = Math.sqrt(Math.pow((pointB.getPointX() - pointA.getPointX()), 2) + Math.pow((pointB.getPointY() - pointA.getPointY()), 2));
        bc = Math.sqrt(Math.pow((pointC.getPointX() - pointB.getPointX()), 2) + Math.pow((pointC.getPointY() - pointB.getPointY()), 2));

        result = 2 * ab + 2 * bc;
        LOGGER.info("Quadrangle calculated perimeter is: {}", result);
        return result;
    }

    public boolean isSidesParallel(Quadrangle Quadrangle) throws QuadrangleException {
        if (Quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        double threshold = 1e-10;
        boolean result;
        Point pointA = Quadrangle.getPointA();
        Point pointB = Quadrangle.getPointB();
        Point pointC = Quadrangle.getPointC();
        Point pointD = Quadrangle.getPointC();

        Point ab = new Point(pointB.getPointX() - pointA.getPointX(), pointB.getPointY() - pointA.getPointY());
        Point cd = new Point(pointC.getPointX() - pointD.getPointX(), pointC.getPointY() - pointD.getPointY());

        result = (Math.abs(ab.getPointX() * cd.getPointY() - ab.getPointY() * cd.getPointX()) < threshold);
        LOGGER.info("Quadrangle has parallel sides: {}", result);
        return result;
    }

    public boolean isSquare(Quadrangle Quadrangle) throws QuadrangleException {
        if (Quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = Quadrangle.getPointA();
        Point pointB = Quadrangle.getPointB();
        Point pointC = Quadrangle.getPointC();
        boolean isParallel = isSidesParallel(Quadrangle);
        boolean isLinesSameLength;
        boolean result;
        double ab, bc;

        ab = Math.sqrt(Math.pow((pointA.getPointX() - pointB.getPointX()), 2) + Math.pow((pointA.getPointY() - pointB.getPointY()), 2));
        bc = Math.sqrt(Math.pow((pointB.getPointX() - pointC.getPointX()), 2) + Math.pow((pointB.getPointY() - pointC.getPointY()), 2));
        isLinesSameLength = ab == bc;

        result = isParallel && isLinesSameLength;
        LOGGER.info("Quadrangle is a square: {}", result);
        return result;
    }

    public boolean isRectangle(Quadrangle Quadrangle) throws QuadrangleException {
        if (Quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = Quadrangle.getPointA();
        Point pointB = Quadrangle.getPointB();
        Point pointC = Quadrangle.getPointC();
        boolean isParallel = isSidesParallel(Quadrangle);
        boolean isLinesNotSameLength;
        boolean result;
        double ab, bc;

        ab = Math.sqrt(Math.pow((pointA.getPointX() - pointB.getPointX()), 2) + Math.pow((pointA.getPointY() - pointB.getPointY()), 2));
        bc = Math.sqrt(Math.pow((pointB.getPointX() - pointC.getPointX()), 2) + Math.pow((pointB.getPointY() - pointC.getPointY()), 2));
        isLinesNotSameLength = ab != bc;

        result = isParallel && isLinesNotSameLength;
        LOGGER.info("Quadrangle is a rectangle: {}", result);
        return result;
    }

    public boolean isQuadrangleCrossingAxis(Quadrangle quadrangle, Double distance, Axis axis) {
        // TODO: 01.12.2021 create this method
        return true;
    }
}