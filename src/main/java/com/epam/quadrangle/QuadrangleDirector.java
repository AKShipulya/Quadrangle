package com.epam.quadrangle;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import com.epam.quadrangle.logic.QuadrangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuadrangleDirector {
    private static final Logger LOGGER = LogManager.getLogger();

    private final DataReader reader;
    private final QuadrangleCreator creator;

    public QuadrangleDirector(DataReader reader, QuadrangleCreator creator) {
        this.reader = reader;
        this.creator = creator;
    }

    public List<QuadrangleObservable> read(String filePath) throws DataException, QuadrangleException, IOException {
        if (filePath == null || filePath.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }

        List<QuadrangleObservable> quadrangles = new ArrayList<>();

        for (String pointsLine : reader.readValidLinesFromFile(filePath)) {
            QuadrangleObservable quadrangle = creator.createQuadrangle(pointsLine);
            quadrangles.add(quadrangle);
        }

        LOGGER.info("Quadrangles were added in list successfully!");
        return quadrangles;
    }
}