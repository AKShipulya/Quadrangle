package com.epam.quadrangle.util;

import java.util.UUID;

public class QuadrangleIdGenerator {
    public Long generateId() {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}