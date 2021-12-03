package com.epam.quadrangle.data;

import java.io.File;

public class QuadrangleLineValidator {
    private static final String REGEX_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){7}([-]?\\d+\\.\\d+)";

    public static boolean isValid(String line) {
        return line.matches(REGEX_FOR_LINE_VALIDATION);
    }

}