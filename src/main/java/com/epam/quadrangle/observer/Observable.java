package com.epam.quadrangle.observer;

import com.epam.quadrangle.exception.QuadrangleException;

public interface Observable {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers() throws QuadrangleException;
}