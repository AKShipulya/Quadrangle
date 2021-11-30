package com.epam.quadrangle.dao;

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

    public List<String> readValidLinesFromFile(String filePath) throws DataException {
        if (!DataValidator.isFileValid(filePath)) {
            throw new DataException("Invalid file or file path!");
        }

        List<String> linesFromFile = new ArrayList<>();

        try {
            Path path = Paths.get(filePath);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line = bufferedReader.readLine();

            if (!DataValidator.isLinesValid(line)) {
                throw new DataException("Invalid line for reading");
            }

            while (line != null) {
                linesFromFile.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new DataException("Reading file error! ", e);
        }

        if (linesFromFile.size() == 0) {
            throw new DataException("There are not valid lines in this file!");
        }

        LOGGER.info("Lines from file were read successfully!");
        return linesFromFile;
    }
}