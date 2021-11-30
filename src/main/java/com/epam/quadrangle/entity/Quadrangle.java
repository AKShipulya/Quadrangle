package com.epam.quadrangle.entity;

import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.service.QuadrangleParametersValidator;
import com.epam.quadrangle.util.QuadrangleIdGenerator;

public class Quadrangle {

    private long QuadrangleId;
    private ShapePoint pointA;
    private ShapePoint pointB;
    private ShapePoint pointC;
    private ShapePoint pointD;

    public Quadrangle(ShapePoint pointA, ShapePoint pointB, ShapePoint pointC, ShapePoint pointD) throws QuadrangleException {
        if (!QuadrangleParametersValidator.areRectangleParametersValid(pointA, pointB, pointC, pointD)) {
            throw new QuadrangleException("Invalid Quadrangle parameters!");
        }
        this.QuadrangleId = QuadrangleIdGenerator.generateId();
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public long getQuadrangleId() {
        return QuadrangleId;
    }

    public void setQuadrangleId(long quadrangleId) {
        this.QuadrangleId = quadrangleId;
    }

    public ShapePoint getPointA() {
        return pointA;
    }

    public void setPointA(ShapePoint pointA) {
        this.pointA = pointA;
    }

    public ShapePoint getPointB() {
        return pointB;
    }

    public void setPointB(ShapePoint pointB) {
        this.pointB = pointB;
    }

    public ShapePoint getPointC() {
        return pointC;
    }

    public void setPointC(ShapePoint pointC) {
        this.pointC = pointC;
    }

    public ShapePoint getPointD() {
        return pointD;
    }

    public void setPointD(ShapePoint pointD) {
        this.pointD = pointD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrangle that = (Quadrangle) o;

        if (!pointA.equals(that.pointA)) return false;
        if (!pointB.equals(that.pointB)) return false;
        if (!pointC.equals(that.pointC)) return false;
        return pointD.equals(that.pointD);
    }

    @Override
    public int hashCode() {
        int result = pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        result = 31 * result + pointD.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append("idGenerator=").append(QuadrangleId);
        sb.append(", pointA=").append(pointA);
        sb.append(", pointB=").append(pointB);
        sb.append(", pointC=").append(pointC);
        sb.append(", pointD=").append(pointD);
        sb.append('}').append("\n");
        return sb.toString();
    }
}