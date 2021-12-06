package com.epam.quadrangle.logic;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QuadrangleCreatorTest {

    @Test
    public void testCreateQuadrangleShouldCreateQuadrangle() throws QuadrangleException {
        //given
        String coordinatesPoints = "10.0 10.0 10.0 40.0 60.0 40.0 60.0 10.0";
        QuadrangleObservable expected = new QuadrangleObservable(1L, new Point(10, 10), new Point(10, 40)
                , new Point(60, 40), new Point(60, 10));
        //when
        QuadrangleValidator VALIDATOR = new QuadrangleValidator();
        DataLinesParser PARSER = new DataLinesParser();
        QuadrangleCreator creator = new QuadrangleCreator(VALIDATOR, PARSER);
        QuadrangleObservable actual = creator.createQuadrangle(coordinatesPoints);
        //then
        Assert.assertEquals(expected, actual);
    }
}