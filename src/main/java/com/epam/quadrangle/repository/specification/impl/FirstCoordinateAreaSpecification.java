package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

// TODO: 08.12.2021  найти все объекты точки которых находятся в первом квадранте
public class FirstCoordinateAreaSpecification implements Specification {

    double Ox = 0.0;
    double Oy = 0.0;

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getPointA().getPointX() > Ox && quadrangle.getPointA().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointB().getPointX() > Ox && quadrangle.getPointB().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointC().getPointX() > Ox && quadrangle.getPointC().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointD().getPointX() > Ox && quadrangle.getPointD().getPointX() < Double.MAX_VALUE
                && quadrangle.getPointA().getPointY() > Oy && quadrangle.getPointA().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointB().getPointY() > Oy && quadrangle.getPointB().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointC().getPointY() > Oy && quadrangle.getPointC().getPointY() < Double.MAX_VALUE
                && quadrangle.getPointD().getPointY() > Oy && quadrangle.getPointD().getPointY() < Double.MAX_VALUE
                ;
    }
}