package com.epam.quadrangle.repository.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.QuadrangleRepository;
import com.epam.quadrangle.repository.specification.Specification;

import java.util.*;

public class QuadrangleRepositoryImpl implements QuadrangleRepository {
    private final Map<Long, QuadrangleObservable> STORE = new HashMap<>();

    @Override
    public void add(QuadrangleObservable quadrangle) {
        STORE.put(quadrangle.getID() ,quadrangle);
    }

    @Override
    public void addAll(Map<Long, QuadrangleObservable> quadrangles) {
        STORE.putAll(quadrangles);
    }

    @Override
    public void delete(QuadrangleObservable quadrangle) {
        STORE.remove(quadrangle.getID());
    }

    @Override
    public void update(QuadrangleObservable quadrangle) {
        STORE.replace(quadrangle.getID(), quadrangle);
    }

    @Override
    public List<QuadrangleObservable> query(Specification specification) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>();
        for (QuadrangleObservable quadrangle : STORE.values()) {
            if (specification.specified(quadrangle)) {
                quadrangles.add(quadrangle);
            }
        }
        return quadrangles;
    }

    @Override
    public List<QuadrangleObservable> sort(Comparator<QuadrangleObservable> comparator) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>(STORE.values());
        quadrangles.sort(comparator);
        return quadrangles;
    }
}