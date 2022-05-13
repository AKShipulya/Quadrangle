package com.epam.quadrangle.repository;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface QuadrangleRepository {
    void add(QuadrangleObservable quadrangle);

    void addAll(Map<Long, QuadrangleObservable> quadrangles);

    void delete(QuadrangleObservable quadrangle);

    void update(QuadrangleObservable quadrangle);

    List<QuadrangleObservable> query(Specification specification);

    List<QuadrangleObservable> sort(Comparator<QuadrangleObservable> comparator);
}