package com.epam.quadrangle.service;

import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.entity.ShapePoint;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int NUMBER_OF_COORDINATES = 8;

    public Quadrangle createQuadrangle(List<Double> coordinates) throws QuadrangleException {
        if (coordinates.size() != NUMBER_OF_COORDINATES) {
            throw new QuadrangleException("Invalid number of coordinates" + coordinates);
        }

        ShapePoint pointA = new ShapePoint(coordinates.get(0), coordinates.get(1));
        ShapePoint pointB = new ShapePoint(coordinates.get(2), coordinates.get(3));
        ShapePoint pointC = new ShapePoint(coordinates.get(4), coordinates.get(5));
        ShapePoint pointD = new ShapePoint(coordinates.get(6), coordinates.get(7));

        LOGGER.info("Quadrangle was created successfully!");
        return new Quadrangle(pointA, pointB, pointC, pointD);
    }
}