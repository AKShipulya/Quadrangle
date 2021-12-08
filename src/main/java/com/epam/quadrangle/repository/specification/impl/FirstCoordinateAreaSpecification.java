package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class FirstCoordinateAreaSpecification implements Specification {

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        double Ox = 0.0;
        double oy = 0.0;
        return quadrangle.getPointA().getPointX() > Ox && quadrangle.getPointA().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointB().getPointX() > Ox && quadrangle.getPointB().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointC().getPointX() > Ox && quadrangle.getPointC().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointD().getPointX() > Ox && quadrangle.getPointD().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointA().getPointY() > oy && quadrangle.getPointA().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointB().getPointY() > oy && quadrangle.getPointB().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointC().getPointY() > oy && quadrangle.getPointC().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointD().getPointY() > oy && quadrangle.getPointD().getPointY() < Double.MAX_VALUE
                ;
    }
}