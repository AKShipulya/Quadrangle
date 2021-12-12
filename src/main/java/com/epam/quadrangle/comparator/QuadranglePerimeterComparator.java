package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class QuadranglePerimeterComparator implements Comparator<QuadrangleObservable> {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(QuadrangleObservable o1, QuadrangleObservable o2) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double o1Area = 0.0;
        double o2Area = 0.0;
        try {
            o1Area = calculator.calculateQuadranglePerimeter(o1);
            o2Area = calculator.calculateQuadranglePerimeter(o2);
        } catch (QuadrangleException e) {
            LOGGER.warn(e);
        }
        return Double.compare(o1Area, o2Area);
    }
}