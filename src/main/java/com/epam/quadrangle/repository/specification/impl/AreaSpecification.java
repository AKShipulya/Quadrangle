package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;

public class AreaSpecification implements Specification {
    private final double fromArea;
    private final double toArea;

    public AreaSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double area = calculator.calculateQuadrangleArea(quadrangle);
        return area >= fromArea && area <= toArea;
    }
}