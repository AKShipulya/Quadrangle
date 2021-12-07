package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

//найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат
public class DistanceSpecification implements Specification {
    private final double fromRange;
    private final double toRange;

    public DistanceSpecification(double fromRange, double toRange) {
        this.fromRange = fromRange;
        this.toRange = toRange;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return false;
    }
}
