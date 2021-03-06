package com.epam.quadrangle.repository.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.QuadrangleRepository;
import com.epam.quadrangle.repository.specification.Specification;

import java.util.*;

public class QuadrangleRepositoryImpl implements QuadrangleRepository {
    private final Map<Long, QuadrangleObservable> store = new HashMap<>();

    @Override
    public void add(QuadrangleObservable quadrangle) {
        store.put(quadrangle.getId() ,quadrangle);
    }

    @Override
    public void addAll(Map<Long, QuadrangleObservable> quadrangles) {
        store.putAll(quadrangles);
    }

    @Override
    public void delete(QuadrangleObservable quadrangle) {
        store.remove(quadrangle.getId());
    }

    @Override
    public void update(QuadrangleObservable quadrangle) {
        store.replace(quadrangle.getId(), quadrangle);
    }

    @Override
    public List<QuadrangleObservable> query(Specification specification) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>();
        for (QuadrangleObservable quadrangle : store.values()) {
            if (specification.specified(quadrangle)) {
                quadrangles.add(quadrangle);
            }
        }
        return quadrangles;
    }

    @Override
    public List<QuadrangleObservable> sort(Comparator<QuadrangleObservable> comparator) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>(store.values());
        quadrangles.sort(comparator);
        return quadrangles;
    }
}