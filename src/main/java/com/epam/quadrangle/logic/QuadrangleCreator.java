package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    private final QuadrangleValidator QUADRANGLE_VALIDATOR;

    public QuadrangleCreator(QuadrangleValidator quadrangleValidator) {
        this.QUADRANGLE_VALIDATOR = quadrangleValidator;
    }

    public Quadrangle createQuadrangle(List<Double> coordinates) throws QuadrangleException {

        Point pointA = new Point(coordinates.get(0), coordinates.get(1));
        Point pointB = new Point(coordinates.get(2), coordinates.get(3));
        Point pointC = new Point(coordinates.get(4), coordinates.get(5));
        Point pointD = new Point(coordinates.get(6), coordinates.get(7));

        Quadrangle quadrangle = new Quadrangle(pointA, pointB, pointC, pointD);
        if (!QUADRANGLE_VALIDATOR.isValid(quadrangle)) {
            throw new QuadrangleException("Quadrangle cannot be created!");
        }
        LOGGER.info("Quadrangle was created successfully!");
        return quadrangle;
    }
}