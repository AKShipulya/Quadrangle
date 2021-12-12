package com.epam.quadrangle.observer;

public class Parameters {
    private final double AREA;
    private final double PERIMETER;

    public Parameters(double AREA, double PERIMETER) {
        this.AREA = AREA;
        this.PERIMETER = PERIMETER;
    }

    public double getAREA() {
        return AREA;
    }

    public double getPERIMETER() {
        return PERIMETER;
    }
}