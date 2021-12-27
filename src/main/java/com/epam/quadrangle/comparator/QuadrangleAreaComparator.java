package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.logic.QuadrangleCalculator;

import java.util.Comparator;

public class QuadrangleAreaComparator implements Comparator<QuadrangleObservable> {

    @Override
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        QuadrangleCalculator calculator = new QuadrangleCalculator();
        double firstObservableQuadrangleArea = calculator.calculateQuadrangleArea(firstObservableQuadrangle);
        double secondObservableQuadrangleArea = calculator.calculateQuadrangleArea(secondObservableQuadrangle);
        return Double.compare(firstObservableQuadrangleArea, secondObservableQuadrangleArea);
    }

}
