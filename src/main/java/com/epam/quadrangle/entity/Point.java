package com.epam.quadrangle.entity;

public class Point {

    private double pointX;
    private double pointY;

    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point that = (Point) o;

        if (Double.compare(that.pointX, pointX) != 0) {
            return false;
        }
        return Double.compare(that.pointY, pointY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pointX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pointY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShapePoint{");
        sb.append("pointX=").append(pointX);
        sb.append(", pointY=").append(pointY);
        sb.append('}');
        return sb.toString();
    }
}