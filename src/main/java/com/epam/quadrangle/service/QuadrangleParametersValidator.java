package com.epam.quadrangle.service;

import com.epam.quadrangle.entity.ShapePoint;

public class QuadrangleParametersValidator {

    public static boolean areRectangleParametersValid(ShapePoint pointA, ShapePoint pointB,
                                                      ShapePoint pointC, ShapePoint pointD) {
        if (pointA == null && pointB == null && pointC == null && pointD == null) {
            return false;
        }
        return pointA.getPointX() == pointB.getPointX()
                && pointC.getPointX() == pointD.getPointX()
                && pointB.getPointY() == pointC.getPointY()
                && pointA.getPointY() == pointD.getPointY();
    }
}
