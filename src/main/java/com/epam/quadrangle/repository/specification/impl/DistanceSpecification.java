package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class DistanceSpecification implements Specification {
    private final double fromRangeX;
    private final double toRangeX;
    private final double fromRangeY;
    private final double toRangeY;

    public DistanceSpecification(double fromRangeX, double toRangeX, double fromRangeY, double toRangeY) {
        this.fromRangeX = fromRangeX;
        this.toRangeX = toRangeX;
        this.fromRangeY = fromRangeY;
        this.toRangeY = toRangeY;
    }

    /**
     * Some simplification:
     *
     * @return true if points A and D (bottom part of a quadrangle) are located in given range
     * relatively OX and OY coordinate plane axes.
     */
    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getPointA().getPointX() > fromRangeX && quadrangle.getPointA().getPointX() < toRangeX
                && quadrangle.getPointD().getPointX() > fromRangeX && quadrangle.getPointD().getPointX() < toRangeX
                && quadrangle.getPointA().getPointY() > fromRangeY && quadrangle.getPointA().getPointY() < toRangeY
                && quadrangle.getPointD().getPointY() > fromRangeY && quadrangle.getPointD().getPointX() < toRangeY
                ;
    }
}