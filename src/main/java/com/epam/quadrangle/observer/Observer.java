package com.epam.quadrangle.observer;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.QuadrangleException;

public interface Observer {

    void update(QuadrangleObservable quadrangle) throws QuadrangleException;

}