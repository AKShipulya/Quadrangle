package com.epam.quadrangle.repository;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.impl.AreaSpecification;
import com.epam.quadrangle.repository.specification.impl.IdSpecification;
import com.epam.quadrangle.repository.impl.QuadrangleRepositoryImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        QuadrangleObservable quadrangle = new QuadrangleObservable(1L, new Point(10, 10), new Point(10, 40)
                , new Point(60, 40), new Point(60, 10));
        QuadrangleObservable quadrangle2 = new QuadrangleObservable(101L, new Point(11, 10), new Point(10, 40)
                , new Point(60, 40), new Point(60, 10));
        QuadrangleRepository repository = new QuadrangleRepositoryImpl();

        repository.add(quadrangle);
        repository.add(quadrangle2);

        List<QuadrangleObservable> specifiedQuadranglesById = repository.query(new IdSpecification(1L,100L));
        List<QuadrangleObservable> specifiedQuadranglesByArea = repository.query(new AreaSpecification(1000.00, 1499.00));
        System.out.println(specifiedQuadranglesById);
        System.out.println(specifiedQuadranglesByArea);
    }
}
