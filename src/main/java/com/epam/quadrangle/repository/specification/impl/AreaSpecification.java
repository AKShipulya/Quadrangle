package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import com.epam.quadrangle.repository.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AreaSpecification implements Specification {
    private final static Logger LOGGER = LogManager.getLogger();
    private final double fromArea;
    private final double toArea;

    public AreaSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        double area = 0.0;

        try {
            QuadrangleCalculator calculator = new QuadrangleCalculator();
            area = calculator.calculateQuadrangleArea(quadrangle);
        } catch (QuadrangleException e) {
            LOGGER.warn(e);
        }
        return (Double.compare(area, fromArea) == 1 && Double.compare(area, toArea) == -1);
    }
}
