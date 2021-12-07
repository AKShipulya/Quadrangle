package com.epam.quadrangle.repository.specification.impl;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.repository.specification.Specification;

public class IdSpecification implements Specification {

    private final Long fromId;
    private final Long toId;

    public IdSpecification(Long fromId, Long toId) {
        this.fromId = fromId;
        this.toId = toId;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getID() >= fromId && quadrangle.getID() <= toId;
    }
}
