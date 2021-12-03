package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;

public class QuadrangleValidator {

    public boolean isValid(Quadrangle quadrangle) {
        if (quadrangle.getPointA() == null && quadrangle.getPointB() == null
                && quadrangle.getPointC() == null && quadrangle.getPointD() == null) {
            return false;
        }
        return quadrangle.getPointA().getPointX() == quadrangle.getPointB().getPointX()
                && quadrangle.getPointC().getPointX() == quadrangle.getPointD().getPointX()
                && quadrangle.getPointB().getPointY() == quadrangle.getPointC().getPointY()
                && quadrangle.getPointA().getPointY() == quadrangle.getPointD().getPointY();
    }
}