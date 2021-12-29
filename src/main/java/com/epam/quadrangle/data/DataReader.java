package com.epam.quadrangle.data;

import com.epam.quadrangle.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> readValidLinesFromFile(String filePath) throws DataException, IOException {
        Path path = Paths.get(filePath);
        BufferedReader bufferedReader = null;
        List<String> linesFromFile = new ArrayList<>();
        try {
            bufferedReader = Files.newBufferedReader(path);
            String line = bufferedReader.readLine();
            while (line != null) {
                linesFromFile.add(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException exception) {
            LOGGER.warn("File not found! File path: {}", exception.getMessage());
            return null;
        } catch (IOException exception) {
            LOGGER.warn("File I/O error! {}", exception.getMessage());
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException exception) {
                    LOGGER.warn("File I/O error! {}", exception.getMessage());
                }
            }
        }
        if (linesFromFile.isEmpty()) {
            LOGGER.info("No data in the file provided! File: {}", linesFromFile);
            return null;
        }
        LOGGER.info("Lines from file were read successfully!");
        return linesFromFile;
    }
}