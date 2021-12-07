package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataLinesParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DELIMITER_REGEX = "\\s+";

    private final QuadrangleLineValidator LINE_VALIDATOR;

    public DataLinesParser(QuadrangleLineValidator LINE_VALIDATOR) {
        this.LINE_VALIDATOR = LINE_VALIDATOR;
    }

    public List<Double> parseToCoordinates(String line) throws DataException {
        if (!LINE_VALIDATOR.isValid(line)) {
            throw new DataException("Invalid line for parsing: " + "[" + line + "]");
        }

        List<Double> coordinatesPoints = new ArrayList<>();

        String[] pointsFromLine = line.split(DELIMITER_REGEX);

        for (String point : pointsFromLine) {
            double parsedPoint = Double.parseDouble(point);
            coordinatesPoints.add(parsedPoint);
        }

        LOGGER.info("Lines were parsed successfully! {}", coordinatesPoints);
        return coordinatesPoints;
    }
}