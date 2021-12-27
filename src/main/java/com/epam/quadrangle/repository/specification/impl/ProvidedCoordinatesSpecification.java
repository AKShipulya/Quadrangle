package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class ProvidedCoordinatesSpecification implements Specification {
    private final double FROM_OX;
    private final double TO_OX;
    private final double FROM_OY;
    private final double TO_OY;

    public ProvidedCoordinatesSpecification(double fromOx, double toOx, double fromOy, double toOy) {
        this.FROM_OX = fromOx;
        this.TO_OX = toOx;
        this.FROM_OY = fromOy;
        this.TO_OY = toOy;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getPointA().getPointX() >= FROM_OX && quadrangle.getPointA().getPointX() <= TO_OX
                && quadrangle.getPointB().getPointX() >= FROM_OX && quadrangle.getPointB().getPointX() <= TO_OX
                && quadrangle.getPointC().getPointX() >= FROM_OX && quadrangle.getPointC().getPointX() <= TO_OX
                && quadrangle.getPointD().getPointX() >= FROM_OX && quadrangle.getPointD().getPointX() <= TO_OX
                && quadrangle.getPointA().getPointY() >= FROM_OY && quadrangle.getPointA().getPointY() <= TO_OY
                && quadrangle.getPointB().getPointY() >= FROM_OY && quadrangle.getPointB().getPointY() <= TO_OY
                && quadrangle.getPointC().getPointY() >= FROM_OY && quadrangle.getPointC().getPointY() <= TO_OY
                && quadrangle.getPointD().getPointY() >= FROM_OY && quadrangle.getPointD().getPointY() <= TO_OY
                ;
    }
}