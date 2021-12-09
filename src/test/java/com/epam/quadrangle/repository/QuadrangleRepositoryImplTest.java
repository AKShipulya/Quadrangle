package com.epam.quadrangle.repository;

import com.epam.quadrangle.comparator.QuadranglePerimeterComparator;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.impl.QuadrangleRepositoryImpl;
import com.epam.quadrangle.repository.specification.impl.IdSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class QuadrangleRepositoryImplTest {
    public final static QuadrangleRepository REPOSITORY = new QuadrangleRepositoryImpl();
    public final static QuadrangleObservable QUADRANGLE_1 = new QuadrangleObservable(1L, new Point(10.00, 10.00),
            new Point(10.00, 40.00), new Point(80.00, 40.00), new Point(80.00, 10.00));
    public final static QuadrangleObservable QUADRANGLE_2 = new QuadrangleObservable(2L, new Point(10.00, 10.00),
            new Point(10.00, 40.00), new Point(60.00, 40.00), new Point(60.00, 10.00));

    //query
    @Test
    public void testQueryShouldReturnSpecifiedRectanglesFromRepository() {
        //given
        REPOSITORY.add(QUADRANGLE_1);
        REPOSITORY.add(QUADRANGLE_2);
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_1, QUADRANGLE_2);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new IdSpecification(0L, 3L));
        //then
        Assert.assertEquals(expected, actual);
    }

    //sort
    @Test
    public void testSortShouldReturnSortedRectanglesListFromRepository() {
        //given
        REPOSITORY.add(QUADRANGLE_1);
        REPOSITORY.add(QUADRANGLE_2);
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_2, QUADRANGLE_1);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.sort(new QuadranglePerimeterComparator());
        //then
        Assert.assertEquals(expected, actual);
    }
}