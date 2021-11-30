package com.epam.quadrangle.dao;

import java.io.File;

public class DataValidator {
    private static final String REGEX_FOR_LINE_VALIDATION = "([-]?\\d+\\.\\d+\\s+){7}([-]?\\d+\\.\\d+)";

    public static boolean isLinesValid(String line) {
        return line.matches(REGEX_FOR_LINE_VALIDATION);
    }

    public static boolean isFileValid(String filePath) {
        boolean result;
        if (filePath == null) {
            result = false;
        }
        File file = new File(filePath);
        result = file.exists() && file.length() != 0;

        return result;
    }
}
