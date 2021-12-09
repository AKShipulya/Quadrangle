package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class DistanceSpecification implements Specification {
    private final double FROM_RANGE_X;
    private final double TO_RANGE_X;
    private final double FROM_RANGE_Y;
    private final double TO_RANGE_Y;

    public DistanceSpecification(double FROM_RANGE_X, double TO_RANGE_X, double FROM_RANGE_Y, double TO_RANGE_Y) {
        this.FROM_RANGE_X = FROM_RANGE_X;
        this.TO_RANGE_X = TO_RANGE_X;
        this.FROM_RANGE_Y = FROM_RANGE_Y;
        this.TO_RANGE_Y = TO_RANGE_Y;
    }

    /**
     * Some simplification:
     * @return true if points A and D (bottom part of a quadrangle) are located in given range
     * relatively OX and OY coordinate plane axes.
     */
    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getPointA().getPointX() > FROM_RANGE_X && quadrangle.getPointA().getPointX() < TO_RANGE_X
                && quadrangle.getPointD().getPointX() > FROM_RANGE_X && quadrangle.getPointD().getPointX() < TO_RANGE_X
                && quadrangle.getPointA().getPointY() > FROM_RANGE_Y && quadrangle.getPointA().getPointY() < TO_RANGE_Y
                && quadrangle.getPointD().getPointY() > FROM_RANGE_Y && quadrangle.getPointD().getPointX() < TO_RANGE_Y
                ;
    }
}