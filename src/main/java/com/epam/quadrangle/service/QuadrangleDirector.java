package com.epam.quadrangle.service;

import com.epam.quadrangle.dao.DataLinesParser;
import com.epam.quadrangle.dao.DataValidator;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.dao.DataReader;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exception.QuadrangleException;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class QuadrangleDirector {

    private final DataReader reader;
    private final QuadrangleCreator creator;

    public QuadrangleDirector(DataReader reader, QuadrangleCreator creator) {
        this.reader = reader;
        this.creator = creator;
    }

    public List<Quadrangle> read(String filePath) throws DataException, QuadrangleException {
        if (filePath == null || filePath.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }

        List<Quadrangle> quadrangles = new ArrayList<>();

        for (String pointsLine : reader.readValidLinesFromFile(filePath)) {
            DataLinesParser parser = new DataLinesParser();
            List<Double> parsedLinesToDouble = parser.parseToCoordinates(pointsLine);

            quadrangles.add(creator.createQuadrangle(parsedLinesToDouble));
        }

        System.out.println(quadrangles);
        return quadrangles;
    }
}