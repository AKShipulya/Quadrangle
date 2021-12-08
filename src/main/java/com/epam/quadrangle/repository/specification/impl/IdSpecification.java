package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class IdSpecification implements Specification {

    private final Long FROM_ID;
    private final Long TO_ID;

    public IdSpecification(Long FROM_ID, Long TO_ID) {
        this.FROM_ID = FROM_ID;
        this.TO_ID = TO_ID;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getID() >= FROM_ID && quadrangle.getID() <= TO_ID;
    }
}
