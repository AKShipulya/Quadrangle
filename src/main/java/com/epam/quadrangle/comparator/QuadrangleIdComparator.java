package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<QuadrangleObservable> {
    @Override
    public int compare(QuadrangleObservable o1, QuadrangleObservable o2) {
        return Long.compare(o1.getID(), o2.getID());
    }
}