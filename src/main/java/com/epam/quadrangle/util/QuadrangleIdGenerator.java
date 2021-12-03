package com.epam.quadrangle.util;

public class QuadrangleIdGenerator {

    private static long quadrangleId;

    public static long generateId() {
        return ++quadrangleId;
    }
}