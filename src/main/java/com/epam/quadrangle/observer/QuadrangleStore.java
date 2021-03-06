package com.epam.quadrangle.observer;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleStore implements Observer {
    private final static Logger LOGGER = LogManager.getLogger();

    private static QuadrangleStore instance = new QuadrangleStore();

    private final Map<Long, Parameters> parameters = new HashMap<>();
    private final QuadrangleCalculator calculator = new QuadrangleCalculator();

    private QuadrangleStore() {
    }

    public void update(QuadrangleObservable quadrangle) throws QuadrangleException {
        double area = calculator.calculateQuadrangleArea(quadrangle);
        double perimeter = calculator.calculateQuadranglePerimeter(quadrangle);
        LOGGER.info("Parameters were updated successfully!");
        parameters.put(quadrangle.getId(), new Parameters(area, perimeter));
    }

    public static QuadrangleStore getInstance() {
        if (instance == null) {
            instance = new QuadrangleStore();
        }
        return instance;
    }
}