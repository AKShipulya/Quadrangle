package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleCalculator {
    private static final Logger LOGGER = LogManager.getLogger();

    public double calculateQuadrangleArea(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();

        double ab = Math.sqrt(Math.pow(pointB.getPointX() - pointA.getPointX(), 2) +
                Math.pow(pointB.getPointY() - pointA.getPointY(), 2));
        double bc = Math.sqrt(Math.pow(pointC.getPointX() - pointB.getPointX(), 2) +
                Math.pow(pointC.getPointY() - pointB.getPointY(), 2));
        double result = ab * bc;

        LOGGER.info("Quadrangle calculated area is: {}", result);
        return result;
    }

    public double calculateQuadranglePerimeter(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();

        double ab = Math.sqrt(Math.pow((pointB.getPointX() - pointA.getPointX()), 2) +
                Math.pow((pointB.getPointY() - pointA.getPointY()), 2));
        double bc = Math.sqrt(Math.pow((pointC.getPointX() - pointB.getPointX()), 2) +
                Math.pow((pointC.getPointY() - pointB.getPointY()), 2));
        double result = 2 * ab + 2 * bc;

        LOGGER.info("Quadrangle calculated perimeter is: {}", result);
        return result;
    }

    public boolean isSidesParallel(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        double threshold = 1e-10;
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();
        Point pointD = quadrangle.getPointD();

        Point ab = new Point(pointB.getPointX() - pointA.getPointX(),
                pointB.getPointY() - pointA.getPointY());
        Point cd = new Point(pointC.getPointX() - pointD.getPointX(),
                pointC.getPointY() - pointD.getPointY());
        boolean result = (Math.abs(ab.getPointX() * cd.getPointY() - ab.getPointY() * cd.getPointX()) < threshold);

        LOGGER.info("Quadrangle has parallel sides: {}", result);
        return result;
    }

    public boolean isSquare(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();

        boolean isParallel = isSidesParallel(quadrangle);

        double ab = Math.sqrt(Math.pow((pointA.getPointX() - pointB.getPointX()), 2) +
                Math.pow((pointA.getPointY() - pointB.getPointY()), 2));
        double bc = Math.sqrt(Math.pow((pointB.getPointX() - pointC.getPointX()), 2) +
                Math.pow((pointB.getPointY() - pointC.getPointY()), 2));

        boolean isLinesSameLength = ab == bc;
        boolean result = isParallel && isLinesSameLength;

        LOGGER.info("Quadrangle is a square: {}", result);
        return result;
    }

    public boolean isRegularRectangle(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        boolean isParallel = isSidesParallel(quadrangle);
        boolean isNotSquare = !isSquare(quadrangle);

        boolean result = isParallel && isNotSquare;

        LOGGER.info("Quadrangle is a regular rectangle: {}", result);
        return result;
    }

    public boolean isQuadrangleCrossingAxis(QuadrangleObservable quadrangle, Double distance, Axis axis) {
        // TODO: 01.12.2021 create this method
        return true;
    }
}