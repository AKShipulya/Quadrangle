package com.epam.quadrangle.service;

import com.epam.quadrangle.dao.DataLinesParser;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.dao.DataReader;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exception.QuadrangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleDirector {
    private static final Logger LOGGER = LogManager.getLogger();

    private final DataReader reader;
    private final DataLinesParser parser;
    private final QuadrangleCreator creator;

    public QuadrangleDirector(DataReader reader, DataLinesParser parser, QuadrangleCreator creator) {
        this.reader = reader;
        this.parser = parser;
        this.creator = creator;
    }

    public List<Quadrangle> read(String filePath) throws DataException, QuadrangleException {
        if (filePath == null || filePath.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }

        List<Quadrangle> quadrangles = new ArrayList<>();

        for (String pointsLine : reader.readValidLinesFromFile(filePath)) {
            List<Double> parsedLinesToDouble = parser.parseToCoordinates(pointsLine);
            Quadrangle quadrangle = creator.createQuadrangle(parsedLinesToDouble);
            quadrangles.add(quadrangle);
        }
        LOGGER.info("Quadrangles were created successfully!");
        return quadrangles;
    }
}