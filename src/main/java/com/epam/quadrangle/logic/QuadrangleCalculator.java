package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleCalculator {
    private static final Logger LOGGER = LogManager.getLogger();

    public double calculateQuadrangleArea(Quadrangle quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point[] points = getPoints(quadrangle);

        double ab = Math.sqrt(Math.pow(points[1].getPointX() - points[0].getPointX(), 2) +
                Math.pow(points[1].getPointY() - points[0].getPointY(), 2));
        double bc = Math.sqrt(Math.pow(points[2].getPointX() - points[1].getPointX(), 2) +
                Math.pow(points[2].getPointY() - points[1].getPointY(), 2));
        double result = ab * bc;

        LOGGER.info("Quadrangle calculated area is: {}", result);
        return result;
    }

    public double calculateQuadranglePerimeter(Quadrangle quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point[] points = getPoints(quadrangle);

        double ab = Math.sqrt(Math.pow((points[1].getPointX() - points[0].getPointX()), 2) +
                Math.pow((points[1].getPointY() - points[0].getPointY()), 2));
        double bc = Math.sqrt(Math.pow((points[2].getPointX() - points[1].getPointX()), 2) +
                Math.pow((points[2].getPointY() - points[1].getPointY()), 2));
        double result = 2 * ab + 2 * bc;

        LOGGER.info("Quadrangle calculated perimeter is: {}", result);
        return result;
    }

    public boolean isSidesParallel(Quadrangle quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        double threshold = 1e-10;
        Point[] points = getPoints(quadrangle);

        Point ab = new Point(points[1].getPointX() - points[0].getPointX(),
                points[1].getPointY() - points[0].getPointY());
        Point cd = new Point(points[2].getPointX() - points[3].getPointX(),
                points[2].getPointY() - points[3].getPointY());
        boolean result = (Math.abs(ab.getPointX() * cd.getPointY() - ab.getPointY() * cd.getPointX()) < threshold);

        LOGGER.info("Quadrangle has parallel sides: {}", result);
        return result;
    }

    public boolean isSquare(Quadrangle quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point[] points = getPoints(quadrangle);
        boolean isParallel = isSidesParallel(quadrangle);

        double ab = Math.sqrt(Math.pow((points[0].getPointX() - points[1].getPointX()), 2) +
                Math.pow((points[0].getPointY() - points[1].getPointY()), 2));
        double bc = Math.sqrt(Math.pow((points[1].getPointX() - points[2].getPointX()), 2) +
                Math.pow((points[1].getPointY() - points[2].getPointY()), 2));
        boolean isLinesSameLength = ab == bc;
        boolean result = isParallel && isLinesSameLength;

        LOGGER.info("Quadrangle is a square: {}", result);
        return result;
    }

    public boolean isRectangle(Quadrangle quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        boolean isParallel = isSidesParallel(quadrangle);
        boolean isNotSquare = !isSquare(quadrangle);

        boolean result = isParallel && isNotSquare;

        LOGGER.info("Quadrangle is a rectangle: {}", result);
        return result;
    }

    public boolean isQuadrangleCrossingAxis(Quadrangle quadrangle, Double distance, Axis axis) {
        // TODO: 01.12.2021 create this method
        return true;
    }

    private Point[] getPoints(Quadrangle quadrangle) {
        return new Point[] {quadrangle.getPointA(), quadrangle.getPointB(),
                quadrangle.getPointC(), quadrangle.getPointD()};
    }
}