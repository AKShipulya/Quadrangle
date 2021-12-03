package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.ShapePoint;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreatorTest {

    @Test
    public void testCreateQuadrangleShouldCreateQuadrangle() throws QuadrangleException {
        //given
            List<Double> coordinatesPoints = new ArrayList<>();
            coordinatesPoints.add(10.0);
            coordinatesPoints.add(10.0);
            coordinatesPoints.add(10.0);
            coordinatesPoints.add(40.0);
            coordinatesPoints.add(60.0);
            coordinatesPoints.add(40.0);
            coordinatesPoints.add(60.0);
            coordinatesPoints.add(10.0);
            Quadrangle expected = new Quadrangle(new ShapePoint(10, 10), new ShapePoint(10, 40)
                    ,new ShapePoint(60, 40), new ShapePoint(60, 10));
        //when
            QuadrangleCreator creator = new QuadrangleCreator();
            Quadrangle actual = creator.createQuadrangle(coordinatesPoints);
        //then
        Assert.assertEquals(expected, actual);
    }
}