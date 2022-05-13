package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;

import java.util.Comparator;

public class QuadranglePointACoordinateYComparator implements Comparator<QuadrangleObservable> {
    @Override
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        Point firstObservableQuadranglePointA = firstObservableQuadrangle.getPointA();
        Point secondObservableQuadranglePointA = secondObservableQuadrangle.getPointA();
        return Double.compare(firstObservableQuadranglePointA.getPointY(), secondObservableQuadranglePointA.getPointY());
    }
}