package com.epam.quadrangle.entity;

import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.observer.Observable;
import com.epam.quadrangle.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleObservable extends Quadrangle implements Observable {
    private final Long id;
    private final List<Observer> observers = new ArrayList<>();

    public QuadrangleObservable(Long id, Point pointA, Point pointB, Point pointC, Point pointD) {
        super(pointA, pointB, pointC, pointD);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws QuadrangleException {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}