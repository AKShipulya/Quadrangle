package com.epam.quadrangle.repository;

import com.epam.quadrangle.comparator.QuadrangleAreaComparator;
import com.epam.quadrangle.comparator.QuadrangleIdComparator;
import com.epam.quadrangle.comparator.QuadranglePerimeterComparator;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.impl.AreaSpecification;
import com.epam.quadrangle.repository.specification.impl.IdSpecification;
import com.epam.quadrangle.repository.impl.QuadrangleRepositoryImpl;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        QuadrangleObservable quadrangle = new QuadrangleObservable(3L, new Point(11.01, 10.01), new Point(10.01, 40.01)
                , new Point(60.01, 40.01), new Point(60.01, 10.01));
        QuadrangleObservable quadrangle2 = new QuadrangleObservable(2L, new Point(12.99, 10.99), new Point(10.99, 40.99)
                , new Point(60.99, 40.99), new Point(60.99, 10.99));
        QuadrangleObservable quadrangle3 = new QuadrangleObservable(1L, new Point(13.50, 10.50), new Point(10.50, 40.50)
                , new Point(60.50, 40.50), new Point(60.50, 10.50));
        QuadrangleRepository repository = new QuadrangleRepositoryImpl();

        repository.add(quadrangle);
        repository.add(quadrangle2);
        repository.add(quadrangle3);

        List<QuadrangleObservable> specifiedQuadranglesById = repository.query(new IdSpecification(1L,200L));
        List<QuadrangleObservable> specifiedQuadranglesByArea = repository.query(new AreaSpecification(1000.00, 1499.00));
//        System.out.println(specifiedQuadranglesById);
//        System.out.println(specifiedQuadranglesByArea);
        repository.sort(new QuadranglePerimeterComparator());
        System.out.println(specifiedQuadranglesById);
    }
}
