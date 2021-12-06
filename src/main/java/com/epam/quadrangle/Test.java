package com.epam.quadrangle;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.data.QuadrangleLineValidator;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import com.epam.quadrangle.logic.QuadrangleValidator;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws DataException, IOException, QuadrangleException {
        //reader for director constructor
        QuadrangleLineValidator lineValidator = new QuadrangleLineValidator();
        DataReader reader = new DataReader(lineValidator);

        //creator for director constructor
        QuadrangleValidator validator = new QuadrangleValidator();
        DataLinesParser parser = new DataLinesParser();
        QuadrangleCreator creator = new QuadrangleCreator(validator, parser);

        QuadrangleDirector director = new QuadrangleDirector(reader, creator);

        director.read("src/main/resources/coordinates.txt");
    }

}
