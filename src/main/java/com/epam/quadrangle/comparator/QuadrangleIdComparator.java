package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<QuadrangleObservable> {
    @Override
    public int compare(QuadrangleObservable firstObservableQuadrangle, QuadrangleObservable secondObservableQuadrangle) {
        return Long.compare(firstObservableQuadrangle.getID(), secondObservableQuadrangle.getID());
    }
}