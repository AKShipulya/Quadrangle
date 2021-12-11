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

    public boolean arePointsLocationAtOneLine(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();

        boolean result = !((pointC.getPointX() - pointA.getPointX()) / (pointB.getPointX() - pointA.getPointX()) ==
                (pointC.getPointY() - pointA.getPointY()) / (pointB.getPointY() - pointA.getPointY()));

        LOGGER.info("rectangle points are not located at a one line: {}", result);
        return result;
    }

    // TODO: 09.12.2021 create isConvexQuadrangle
    public boolean isConvexQuadrangle(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        return true;
    }

    public boolean isRhombus(QuadrangleObservable quadrangle) throws QuadrangleException {
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

        LOGGER.info("Quadrangle is a rhombus: {}", result);
        return result;
    }

    public boolean isSquare(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();
        Point pointD = quadrangle.getPointD();
        double sideAb = Math.sqrt(Math.pow((pointB.getPointX() - pointA.getPointX()), 2) +
                Math.pow((pointB.getPointY() - pointA.getPointY()), 2));
        double sideBc = Math.sqrt(Math.pow((pointC.getPointX() - pointB.getPointX()), 2) +
                Math.pow((pointC.getPointY() - pointB.getPointY()), 2));
        double sideCd = Math.sqrt(Math.pow((pointD.getPointX() - pointC.getPointX()), 2) +
                Math.pow((pointD.getPointY() - pointC.getPointY()), 2));
        double sideAd = Math.sqrt(Math.pow((pointA.getPointX() - pointD.getPointX()), 2) +
                Math.pow((pointA.getPointY() - pointD.getPointY()), 2));
        double diagonalA = Math.sqrt(Math.pow(sideAb, 2) + Math.pow(sideAd, 2));
        double diagonalB = Math.sqrt(Math.pow(sideCd, 2) + Math.pow(sideBc, 2));

        boolean result = isSidesParallel(quadrangle) && Double.compare(sideAb, sideCd) == 0 && Double.compare(sideBc, sideAd) == 0
                && Double.compare(diagonalA, diagonalB) == 0;

        LOGGER.info("Quadrangle is a square: {}", result);
        return result;
    }

    public boolean isTrapezoid(QuadrangleObservable quadrangle) throws QuadrangleException {
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
        Point bc = new Point(pointB.getPointX() - pointC.getPointX(),
                pointB.getPointY() - pointC.getPointY());
        Point ad = new Point(pointD.getPointX() - pointA.getPointX(),
                pointD.getPointY() - pointA.getPointY());

        double sideAb = Math.sqrt(Math.pow((pointB.getPointX() - pointA.getPointX()), 2) +
                Math.pow((pointB.getPointY() - pointA.getPointY()), 2));
        double sideBc = Math.sqrt(Math.pow((pointC.getPointX() - pointB.getPointX()), 2) +
                Math.pow((pointC.getPointY() - pointB.getPointY()), 2));
        double sideCd = Math.sqrt(Math.pow((pointD.getPointX() - pointC.getPointX()), 2) +
                Math.pow((pointD.getPointY() - pointC.getPointY()), 2));
        double sideAd = Math.sqrt(Math.pow((pointA.getPointX() - pointD.getPointX()), 2) +
                Math.pow((pointA.getPointY() - pointD.getPointY()), 2));

        boolean sidesAbAndCdAreNotParallel = !(Math.abs(ab.getPointX() * cd.getPointY() - ab.getPointY() * cd.getPointX()) < threshold);
        boolean sidesBcAndAdAreParallel = Math.abs(bc.getPointX() * ad.getPointY() - bc.getPointY() * ad.getPointX()) < threshold;

        boolean result = sidesAbAndCdAreNotParallel && sidesBcAndAdAreParallel;

        LOGGER.info("Quadrangle is a trapezoid: {}", result);
        return result;

    }

    public boolean isRegularRectangle(QuadrangleObservable quadrangle) throws QuadrangleException {
        if (quadrangle == null) {
            throw new QuadrangleException("Invalid Quadrangle!");
        }
        Point pointA = quadrangle.getPointA();
        Point pointB = quadrangle.getPointB();
        Point pointC = quadrangle.getPointC();
        Point pointD = quadrangle.getPointD();
        double sideAb = Math.sqrt(Math.pow((pointB.getPointX() - pointA.getPointX()), 2) +
                Math.pow((pointB.getPointY() - pointA.getPointY()), 2));
        double sideBc = Math.sqrt(Math.pow((pointC.getPointX() - pointB.getPointX()), 2) +
                Math.pow((pointC.getPointY() - pointB.getPointY()), 2));
        double sideCd = Math.sqrt(Math.pow((pointD.getPointX() - pointC.getPointX()), 2) +
                Math.pow((pointD.getPointY() - pointC.getPointY()), 2));
        double sideAd = Math.sqrt(Math.pow((pointA.getPointX() - pointD.getPointX()), 2) +
                Math.pow((pointA.getPointY() - pointD.getPointY()), 2));
        double diagonalA = Math.sqrt(Math.pow(sideAb, 2) + Math.pow(sideAd, 2));
        double diagonalB = Math.sqrt(Math.pow(sideCd, 2) + Math.pow(sideBc, 2));

        boolean areSideEqualByPair = Double.compare(sideAb, sideCd) == 0 || Double.compare(sideBc, sideAd) == 0;
        boolean areDiagonalsEqual = Double.compare(diagonalA, diagonalB) == 0;

        boolean result = isSidesParallel(quadrangle) && areSideEqualByPair && areDiagonalsEqual;

        LOGGER.info("Quadrangle is a regular rectangle: {}", result);
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
        Point bc = new Point(pointB.getPointX() - pointC.getPointX(),
                pointB.getPointY() - pointC.getPointY());
        Point ad = new Point(pointD.getPointX() - pointA.getPointX(),
                pointD.getPointY() - pointA.getPointY());
        boolean result = ((Math.abs(ab.getPointX() * cd.getPointY() - ab.getPointY() * cd.getPointX()) < threshold))
                && ((Math.abs(bc.getPointX() * ad.getPointY() - bc.getPointY() * ad.getPointX()) < threshold));

        LOGGER.info("Quadrangle has parallel sides: {}", result);
        return result;
    }
}