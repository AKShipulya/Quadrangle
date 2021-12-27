package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;

import java.util.Comparator;

public class QuadranglePerimeterComparator implements Comparator<QuadrangleObservable> {

    @Override
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double firstObservableQuadrangleArea = calculator.calculateQuadranglePerimeter(firstObservableQuadrangle);
        double secondObservableQuadrangleArea = calculator.calculateQuadranglePerimeter(secondObservableQuadrangle);
        return Double.compare(firstObservableQuadrangleArea, secondObservableQuadrangleArea);
    }
}