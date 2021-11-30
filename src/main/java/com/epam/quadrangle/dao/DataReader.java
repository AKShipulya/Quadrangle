package com.epam.quadrangle.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public List<String> read(String filePath) {
        List<String> linesFromFile = new ArrayList<>();

        try {
            Path path = Paths.get(filePath);
            BufferedReader bufferedReader = Files.newBufferedReader(path);
            String line = bufferedReader.readLine();

            while (line != null) {
                linesFromFile.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesFromFile;
    }
}