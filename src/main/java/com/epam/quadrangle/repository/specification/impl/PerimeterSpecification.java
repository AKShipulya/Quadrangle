package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterSpecification implements Specification {
    private final static Logger LOGGER = LogManager.getLogger();
    private final double FROM_PERIMETER;
    private final double TO_PERIMETER;

    public PerimeterSpecification(double FROM_PERIMETER, double TO_PERIMETER) {
        this.FROM_PERIMETER = FROM_PERIMETER;
        this.TO_PERIMETER = TO_PERIMETER;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        double perimeter = 0.0;

        try {
            QuadrangleCalculator calculator = new QuadrangleCalculator();
            perimeter = calculator.calculateQuadranglePerimeter(quadrangle);
        } catch (QuadrangleException e) {
            LOGGER.warn(e);
        }
        return perimeter >= FROM_PERIMETER && perimeter <= TO_PERIMETER;
    }
}