package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataLinesParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DELIMITER_REGEX = "\\s+";
    private static final int COORDINATE_NUMBERS = 8;

    public List<Double> parseToCoordinates(String line) throws DataException {
        if (line == null || line.isEmpty()) {
            throw new DataException("Invalid line of data!");
        }
        List<Double> coordinatesPoints = new ArrayList<>();

        try {
            String[] pointsFromLine = line.split(DELIMITER_REGEX);

            for (String point : pointsFromLine) {
                double parsedPoint = Double.parseDouble(point);
                coordinatesPoints.add(parsedPoint);
            }
        } catch (NumberFormatException e) {
            throw new DataException("Invalid data for coordinates! ", e);
        }

        if (coordinatesPoints.size() != COORDINATE_NUMBERS) {
            throw new DataException("Wrong quantity of the coordinates!");
        }

        LOGGER.info("Lines were parsed successfully!");
        return coordinatesPoints;
    }
}