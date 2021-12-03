package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger LOGGER = LogManager.getLogger();
    private final DataLineValidator VALIDATOR;

    public DataReader(DataLineValidator lineValidator) {
        VALIDATOR = lineValidator;
    }

    public List<String> readValidLinesFromFile(String filePath) throws DataException, IOException {

        Path path = Paths.get(filePath);
        BufferedReader bufferedReader = Files.newBufferedReader(path);
        List<String> linesFromFile = new ArrayList<>();

        try {
            String line = bufferedReader.readLine();

            if (!VALIDATOR.isValid(line)) {
                throw new DataException("Invalid line for reading");
            }

            while (line != null) {
                linesFromFile.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new DataException("Reading file error! ", e);
        } finally {
            bufferedReader.close();
        }

        if (linesFromFile.size() == 0) {
            throw new DataException("There are not valid lines in this file!");
        }

        LOGGER.info("Lines from file were read successfully!");
        return linesFromFile;
    }
}