package com.epam.quadrangle.entity;

import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.observer.Observable;
import com.epam.quadrangle.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleObservable extends Quadrangle implements Observable {

    private final Long ID;
    private final List<Observer> OBSERVERS = new ArrayList<>();

    public QuadrangleObservable(Long ID, Point pointA, Point pointB, Point pointC, Point pointD) {
        super(pointA, pointB, pointC, pointD);
        this.ID = ID;
    }

    public Long getID() {
        return ID;
    }

    @Override
    public void attach(Observer observer) {
        OBSERVERS.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        OBSERVERS.remove(observer);
    }
    
    @Override
    public void notifyObservers() throws QuadrangleException {
        for (Observer observer : OBSERVERS) {
            observer.update(this);
        }
    }
}