package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterSpecification implements Specification {
    private final double FROM_PERIMETER;
    private final double TO_PERIMETER;

    public PerimeterSpecification(double fromPerimeter, double toPerimeter) {
        this.FROM_PERIMETER = fromPerimeter;
        this.TO_PERIMETER = toPerimeter;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double perimeter = calculator.calculateQuadranglePerimeter(quadrangle);
        return perimeter >= FROM_PERIMETER && perimeter <= TO_PERIMETER;
    }
}