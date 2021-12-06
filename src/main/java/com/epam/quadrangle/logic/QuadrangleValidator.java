package com.epam.quadrangle.logic;

import com.epam.quadrangle.entity.QuadrangleObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QuadrangleValidator {
    private final static Logger LOGGER = LogManager.getLogger();

    public boolean isValid(QuadrangleObservable quadrangle) {
        if (quadrangle.getPointA() == null && quadrangle.getPointB() == null
                && quadrangle.getPointC() == null && quadrangle.getPointD() == null) {
            return false;
        }
        LOGGER.info("Quadrangle is valid!");
        return quadrangle.getPointA().getPointX() != quadrangle.getPointC().getPointX()
                && quadrangle.getPointA().getPointX() != quadrangle.getPointD().getPointX()
                && quadrangle.getPointB().getPointX() != quadrangle.getPointC().getPointX()
                && quadrangle.getPointB().getPointX() != quadrangle.getPointD().getPointX()
                && quadrangle.getPointA().getPointY() != quadrangle.getPointC().getPointY()
                && quadrangle.getPointB().getPointY() != quadrangle.getPointD().getPointY();
    }
}