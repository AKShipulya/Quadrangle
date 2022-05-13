package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class ProvidedCoordinatesSpecification implements Specification {
    private final double fromOx;
    private final double toOx;
    private final double fromOy;
    private final double toOy;

    public ProvidedCoordinatesSpecification(double fromOx, double toOx, double fromOy, double toOy) {
        this.fromOx = fromOx;
        this.toOx = toOx;
        this.fromOy = fromOy;
        this.toOy = toOy;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getPointA().getPointX() >= fromOx && quadrangle.getPointA().getPointX() <= toOx
                && quadrangle.getPointB().getPointX() >= fromOx && quadrangle.getPointB().getPointX() <= toOx
                && quadrangle.getPointC().getPointX() >= fromOx && quadrangle.getPointC().getPointX() <= toOx
                && quadrangle.getPointD().getPointX() >= fromOx && quadrangle.getPointD().getPointX() <= toOx
                && quadrangle.getPointA().getPointY() >= fromOy && quadrangle.getPointA().getPointY() <= toOy
                && quadrangle.getPointB().getPointY() >= fromOy && quadrangle.getPointB().getPointY() <= toOy
                && quadrangle.getPointC().getPointY() >= fromOy && quadrangle.getPointC().getPointY() <= toOy
                && quadrangle.getPointD().getPointY() >= fromOy && quadrangle.getPointD().getPointY() <= toOy
                ;
    }
}