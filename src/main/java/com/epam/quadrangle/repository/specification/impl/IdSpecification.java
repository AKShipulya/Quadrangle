package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class IdSpecification implements Specification {
    private final Long FROM_ID;
    private final Long TO_ID;

    public IdSpecification(Long fromId, Long toId) {
        this.FROM_ID = fromId;
        this.TO_ID = toId;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getID() >= FROM_ID && quadrangle.getID() <= TO_ID;
    }
}