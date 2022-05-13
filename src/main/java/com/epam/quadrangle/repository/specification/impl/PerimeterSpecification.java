package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;

public class PerimeterSpecification implements Specification {
    private final double fromPerimeter;
    private final double toPerimeter;

    public PerimeterSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double perimeter = calculator.calculateQuadranglePerimeter(quadrangle);
        return perimeter >= fromPerimeter && perimeter <= toPerimeter;
    }
}