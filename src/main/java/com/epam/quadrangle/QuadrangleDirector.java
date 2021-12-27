package com.epam.quadrangle;

import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuadrangleDirector {
    private static final Logger LOGGER = LogManager.getLogger();

    private final DataReader READER;
    private final QuadrangleCreator CREATOR;

    public QuadrangleDirector(DataReader READER, QuadrangleCreator CREATOR) {
        this.READER = READER;
        this.CREATOR = CREATOR;
    }

    public List<QuadrangleObservable> read(String filePath) throws DataException {
        if (filePath == null || filePath.isEmpty()) {
            throw new DataException("Invalid path to file with data");
        }
        List<QuadrangleObservable> quadrangles = new ArrayList<>();

        try {
            for (String pointsLine : READER.readValidLinesFromFile(filePath)) {
                QuadrangleObservable quadrangle = CREATOR.createQuadrangle(pointsLine);
                quadrangles.add(quadrangle);
            }
        } catch (DataException | QuadrangleException | IOException e) {
            LOGGER.warn(e);
        }
        return quadrangles;
    }
}