package com.epam.quadrangle.dao;

import java.util.ArrayList;
import java.util.List;

public class DataLinesParser {

    private static final String DELIMITER_REGEX = "\\s+";

    public List<Double> parseToCoordinates(String line) {
        List<Double> coordinatesPoints = new ArrayList<>();

        String[] pointsFromLine = line.split(DELIMITER_REGEX);

        for (String point : pointsFromLine) {
            double parsedPoint = Double.parseDouble(point);
            coordinatesPoints.add(parsedPoint);

        }
        return coordinatesPoints;
    }
}