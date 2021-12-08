package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

// TODO: 08.12.2021 найти объекты находящиеся на расстоянии в заданном диапазоне от начала координат
public class DistanceSpecification implements Specification {
    private final double FROM_RANGE;
    private final double TO_RANGE;

    public DistanceSpecification(double FROM_RANGE, double TO_RANGE) {
        this.FROM_RANGE = FROM_RANGE;
        this.TO_RANGE = TO_RANGE;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return false;
    }
}
