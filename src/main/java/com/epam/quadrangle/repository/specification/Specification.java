package com.epam.quadrangle.repository.specification;

import com.epam.quadrangle.entity.QuadrangleObservable;

public interface Specification {

    boolean specified(QuadrangleObservable quadrangle);

}
