package com.epam.quadrangle.observer;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleStore implements Observer {

    private static QuadrangleStore instance = new QuadrangleStore();

    private final Map<Long, Parameters> PARAMETERS = new HashMap<>();
    private final QuadrangleCalculator CALCULATOR = new QuadrangleCalculator();

    private QuadrangleStore() {

    }

    // TODO: 03.12.2021 add logger if needed!
    public void update(QuadrangleObservable quadrangle) throws QuadrangleException {
        double area = CALCULATOR.calculateQuadrangleArea(quadrangle);
        double perimeter = CALCULATOR.calculateQuadranglePerimeter(quadrangle);
        PARAMETERS.put(quadrangle.getID(), new Parameters(area, perimeter));
    }

    public static QuadrangleStore getInstance() {
        if (instance == null) {
            instance = new QuadrangleStore();
        }
        return instance;
    }

}