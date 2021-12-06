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
        QuadrangleValidator validator = new QuadrangleValidator();
        QuadrangleLineValidator lineValidator = new QuadrangleLineValidator();
        DataLinesParser parser = new DataLinesParser();

        QuadrangleCreator creator = new QuadrangleCreator(validator, parser);
        DataReader reader = new DataReader(lineValidator);

        QuadrangleDirector director = new QuadrangleDirector(reader, creator, validator);

        director.read("src/main/resources/coordinates.txt");
    }

}
