package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;

import java.util.Comparator;

public class QuadranglePointACoordinateYComparator implements Comparator<QuadrangleObservable> {
    @Override
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        return Double.compare(firstObservableQuadrangle.getPointA().getPointY(), secondObservableQuadrangle.getPointA().getPointY());
    }
}