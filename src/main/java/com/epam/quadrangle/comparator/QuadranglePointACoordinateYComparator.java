package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;

import java.util.Comparator;

public class QuadranglePointACoordinateYComparator implements Comparator<QuadrangleObservable> {

    @Override
    public int compare(QuadrangleObservable o1, QuadrangleObservable o2) {
        return Double.compare(o1.getPointA().getPointY(), o2.getPointA().getPointY());
    }
}
