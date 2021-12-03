package com.epam.quadrangle;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.entity.Quadrangle;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
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

    public List<Quadrangle> read(String filePath) throws DataException, QuadrangleException, IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }

        List<Quadrangle> quadrangles = new ArrayList<>();

        try {
            for (String pointsLine : reader.readValidLinesFromFile(filePath)) {
                List<Double> parsedLinesToDouble = parser.parseToCoordinates(pointsLine);
                Quadrangle quadrangle = creator.createQuadrangle(parsedLinesToDouble);
                quadrangles.add(quadrangle);
            }
        } catch (NumberFormatException e) {
            throw new DataException(e);
        }
        LOGGER.info("Quadrangles were created successfully!");
        return quadrangles;
    }
}