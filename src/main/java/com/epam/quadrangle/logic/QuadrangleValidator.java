package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.QuadrangleObservable;

public class QuadrangleValidator {

    public boolean isValid(QuadrangleObservable quadrangle) {
        if (quadrangle.getPointA() == null && quadrangle.getPointB() == null
                && quadrangle.getPointC() == null && quadrangle.getPointD() == null) {
            return false;
        }
        return quadrangle.getPointA().getPointX() != quadrangle.getPointC().getPointX()
                && quadrangle.getPointA().getPointX() != quadrangle.getPointD().getPointX()
                && quadrangle.getPointB().getPointX() != quadrangle.getPointC().getPointX()
                && quadrangle.getPointB().getPointX() != quadrangle.getPointD().getPointX()
                && quadrangle.getPointA().getPointY() != quadrangle.getPointC().getPointY()
                && quadrangle.getPointB().getPointY() != quadrangle.getPointD().getPointY();
    }
}