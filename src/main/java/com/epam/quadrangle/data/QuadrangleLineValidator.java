package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;

public class QuadrangleLineValidator {
    private static final String REGEX_FOR_LINE_VALIDATION = "([-]?\\d+\\.[0-9]\\s+){7}([-]?\\d+\\.[0-9])";
    private static final String DELIMITER_REGEX = "\\s+";
    private static final int COORDINATE_NUMBERS = 8;

    public boolean isValid(String line) throws DataException {
        if (line == null || line.isEmpty()) {
            throw new DataException("Invalid line of data!");
        }
        String[] pointsFromLine = line.split(DELIMITER_REGEX);
        return line.matches(REGEX_FOR_LINE_VALIDATION) && pointsFromLine.length == COORDINATE_NUMBERS;
    }
}