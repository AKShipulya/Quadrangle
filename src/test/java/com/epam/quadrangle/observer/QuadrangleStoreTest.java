package com.epam.quadrangle.observer;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class QuadrangleStoreTest {
    // TODO: 03.12.2021 !!!!!
    @Test
    public void testUpdateShouldUpdateParameters() throws QuadrangleException {
        //given
        QuadrangleObservable quadrangle = new QuadrangleObservable(new Point(10, 10), new Point(10, 40)
                , new Point(60, 40), new Point(60, 10));
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double area = calculator.calculateQuadrangleArea(quadrangle);
        double perimeter = calculator.calculateQuadranglePerimeter(quadrangle);
        Parameters parameter = new Parameters(area, perimeter);
        Map<Long, Parameters> parameters = new HashMap<>();
        parameters.put(quadrangle.getID(), parameter);
        QuadrangleStore store = QuadrangleStore.getInstance();
        quadrangle.attach(store);

    }
}