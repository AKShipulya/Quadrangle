package com.epam.quadrangle.specification;

import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.QuadrangleRepository;
import com.epam.quadrangle.repository.impl.QuadrangleRepositoryImpl;
import com.epam.quadrangle.repository.specification.impl.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrangleSpecificationTest {
    private final QuadrangleRepository REPOSITORY = new QuadrangleRepositoryImpl();
    private final QuadrangleObservable QUADRANGLE_1 = new QuadrangleObservable(3L, new Point(10.00, 10.00),
            new Point(10.00, 40.00), new Point(60.00, 40.00), new Point(60.00, 10.00));
    private final QuadrangleObservable QUADRANGLE_2 = new QuadrangleObservable(2L, new Point(12.99, 10.99),
            new Point(10.99, 40.99), new Point(60.99, 40.99), new Point(60.99, 10.99));
    private final QuadrangleObservable QUADRANGLE_3 = new QuadrangleObservable(1L, new Point(13.50, 10.50),
            new Point(10.50, 40.50), new Point(60.50, 40.50), new Point(60.50, 10.50));
    private final QuadrangleObservable QUADRANGLE_MINUS = new QuadrangleObservable(4L, new Point(-13.50, -10.50),
            new Point(-10.50, -40.50), new Point(-60.50, -40.50), new Point(-60.50, -10.50));
    private final QuadrangleObservable QUADRANGLE_MINUS_PLUS = new QuadrangleObservable(5L, new Point(-13.50, 10.50),
            new Point(-13.50, 40.50), new Point(60.50, 40.50), new Point(60.50, 10.50));

    @Before
    public void setUp() {
        REPOSITORY.add(QUADRANGLE_1);
        REPOSITORY.add(QUADRANGLE_2);
        REPOSITORY.add(QUADRANGLE_3);
        REPOSITORY.add(QUADRANGLE_MINUS);
        REPOSITORY.add(QUADRANGLE_MINUS_PLUS);
    }

    //AreaSpecification
    @Test
    public void testAreaSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_1);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new AreaSpecification(1500.00, 1500.00));
        //then
        Assert.assertEquals(expected, actual);
    }

    // TODO: 08.12.2021 create this test after DistanceSpecification fix
    //DistanceSpecification
    @Test
    public void testDistanceSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        //when
        //then
    }

    //FirstCoordinateAreaSpecification
    @Test
    public void testFirstCoordinateAreaSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_3, QUADRANGLE_2, QUADRANGLE_1);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new FirstCoordinateAreaSpecification());
        //then
        Assert.assertEquals(expected, actual);
    }

    //IdSpecification
    @Test
    public void testIdSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_3, QUADRANGLE_2);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new IdSpecification(1L, 2L));
        //then
        Assert.assertEquals(expected, actual);
    }

    //PerimeterSpecification
    @Test
    public void testPerimeterSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_2, QUADRANGLE_1);
        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new PerimeterSpecification(160.00, 160.20));
        //then
        Assert.assertEquals(expected, actual);
    }

    //ProvidedCoordinatesSpecification
    @Test
    public void testProvidedCoordinatesSpecificationShouldReturnSpecifiedQuadrangles() {
        //given
        List<QuadrangleObservable> expected = Arrays.asList(QUADRANGLE_1);
        //when
        List<QuadrangleObservable> actual =
                REPOSITORY.query(new ProvidedCoordinatesSpecification(0, 100, 0, 40.20));
        //then
        Assert.assertEquals(expected, actual);
    }
}