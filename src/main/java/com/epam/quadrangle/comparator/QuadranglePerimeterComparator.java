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
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double firstObservableQuadrangleArea = 0.0;
        double secondObservableQuadrangleArea = 0.0;
        try {
            firstObservableQuadrangleArea = calculator.calculateQuadranglePerimeter(firstObservableQuadrangle);
            secondObservableQuadrangleArea = calculator.calculateQuadranglePerimeter(secondObservableQuadrangle);
        } catch (QuadrangleException exception) {
            LOGGER.warn(exception);
        }
        return Double.compare(firstObservableQuadrangleArea, secondObservableQuadrangleArea);
    }
}