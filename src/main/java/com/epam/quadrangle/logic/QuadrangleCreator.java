package com.epam.quadrangle.logic;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.entity.Point;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.util.QuadrangleIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuadrangleCreator {
    private static final Logger LOGGER = LogManager.getLogger();
    private final QuadrangleValidator QUADRANGLE_VALIDATOR;
    private final DataLinesParser PARSER;

    public QuadrangleCreator(QuadrangleValidator quadrangleValidator, DataLinesParser parser) {
        this.QUADRANGLE_VALIDATOR = quadrangleValidator;
        this.PARSER = parser;
    }

    public QuadrangleObservable createQuadrangle(String coordinatesList) throws QuadrangleException, DataException {
        QuadrangleIdGenerator idGenerator = new QuadrangleIdGenerator();
        List<Double> parsedLinesToDouble = PARSER.parseToCoordinates(coordinatesList);

        Long ID = idGenerator.generateId();
        Point pointA = new Point(parsedLinesToDouble.get(0), parsedLinesToDouble.get(1));
        Point pointB = new Point(parsedLinesToDouble.get(2), parsedLinesToDouble.get(3));
        Point pointC = new Point(parsedLinesToDouble.get(4), parsedLinesToDouble.get(5));
        Point pointD = new Point(parsedLinesToDouble.get(6), parsedLinesToDouble.get(7));

        QuadrangleObservable quadrangle = new QuadrangleObservable(ID, pointA, pointB, pointC, pointD);

        if (!QUADRANGLE_VALIDATOR.isValid(quadrangle)) {
            throw new QuadrangleException("Quadrangle cannot be created!");
        }

        LOGGER.info("Quadrangle was created successfully! ID: {}", quadrangle.getID());
        return quadrangle;
    }
}