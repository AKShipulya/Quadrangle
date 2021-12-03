package com.epam.quadrangle.data;

public class DataLineValidator {
    private static final String REGEX_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){7}([-]?\\d+\\.\\d+)";

    public boolean isValid(String line) {
        return line.matches(REGEX_FOR_LINE_VALIDATION);
    }

}