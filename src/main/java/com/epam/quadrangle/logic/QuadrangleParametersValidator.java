package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Point;

public class QuadrangleParametersValidator {

    public boolean isQuadrangleValid(Point pointA, Point pointB,
                                            Point pointC, Point pointD) {
        if (pointA == null && pointB == null && pointC == null && pointD == null) {
            return false;
        }
        return pointA.getPointX() == pointB.getPointX()
                && pointC.getPointX() == pointD.getPointX()
                && pointB.getPointY() == pointC.getPointY()
                && pointA.getPointY() == pointD.getPointY();
    }
}
