package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification implements Specification {
    private final double FROM_AREA;
    private final double TO_AREA;

    public AreaSpecification(double fromArea, double toArea) {
        this.FROM_AREA = fromArea;
        this.TO_AREA = toArea;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double area = calculator.calculateQuadrangleArea(quadrangle);
        return area >= FROM_AREA && area <= TO_AREA;
    }
}