package com.epam.quadrangle.service;

import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.dao.DataReader;
import com.epam.quadrangle.entity.Quadrangle;

import java.util.List;

public class QuadrangleDirector {
    private static final String FILE_PATH = "src/main/resources/coordinates.txt";

    private DataReader reader;
    private QuadrangleValidator validator;
    private QuadrangleCreator creator;

    public QuadrangleDirector(DataReader reader) {
        this.reader = reader;
    }
    
    public List<Quadrangle> read(String FILE_PATH) throws DataException {
        if (FILE_PATH == null || FILE_PATH.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }
        // TODO: 30.11.2021 create method logic! 
        return null;
    }
}
