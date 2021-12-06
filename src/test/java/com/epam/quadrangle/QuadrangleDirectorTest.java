package com.epam.quadrangle;

import com.epam.quadrangle.data.DataLinesParser;
import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.data.QuadrangleLineValidator;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import com.epam.quadrangle.logic.QuadrangleValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class QuadrangleDirectorTest {
    private final static String FILE_PATH = "testPath";
    private final static String VALID_LINE = "1 2 3";
    private final static String INVALID_LINE = "3 2 1";
    private final static String VALID_COORDINATES_LINE = "1 2 3";
    private final static QuadrangleObservable QUADRANGLE = Mockito.mock(QuadrangleObservable.class);

    @Test
    public void testReadShouldCreateWhenValid() throws DataException, IOException, QuadrangleException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readValidLinesFromFile(anyString())).thenReturn(Arrays.asList(VALID_LINE));

        QuadrangleLineValidator lineValidator = Mockito.mock(QuadrangleLineValidator.class);
        when(lineValidator.isValid(VALID_LINE)).thenReturn(true);

        QuadrangleCreator creator = Mockito.mock(QuadrangleCreator.class);
        when(creator.createQuadrangle(VALID_COORDINATES_LINE)).thenReturn(QUADRANGLE);

        QuadrangleValidator validator = Mockito.mock(QuadrangleValidator.class);
        when(validator.isValid(QUADRANGLE)).thenReturn(true);

        QuadrangleDirector director = new QuadrangleDirector(reader, creator, validator);

        //when
        List<QuadrangleObservable> quadrangles = director.read(FILE_PATH);

        //then
        Assert.assertEquals(1, quadrangles.size());
        Assert.assertEquals(quadrangles.get(0), QUADRANGLE);

        verify(reader, times(1)).readValidLinesFromFile(FILE_PATH);
        verify(creator, times(1)).createQuadrangle(VALID_COORDINATES_LINE);
        verifyNoMoreInteractions(reader, creator);

    }

//    @Test
//    public void testReadShouldNotCreateWhenInvalid() throws DataException, IOException, QuadrangleException {
//        DataReader reader = Mockito.mock(DataReader.class);
//        when(reader.readValidLinesFromFile(anyString())).thenReturn(Arrays.asList(INVALID_LINE));
//
//        DataLinesParser parser = Mockito.mock(DataLinesParser.class);
//
//        QuadrangleCreator creator = Mockito.mock(QuadrangleCreator.class);
//
//        QuadrangleValidator validator = Mockito.mock(QuadrangleValidator.class);
//        when(validator.isValid(QUADRANGLE)).thenReturn(false);
//
//        QuadrangleDirector director = new QuadrangleDirector(reader, parser, creator, validator);
//
//        //when
//        List<Quadrangle> quadrangles = director.read(FILE_PATH);
//
//        //then
//        Assert.assertEquals(0, quadrangles.size());
//
//        verify(reader, times(0)).readValidLinesFromFile(FILE_PATH);
//        verify(parser, times(0)).parseToCoordinates(VALID_LINE);
//        verify(creator, times(0)).createQuadrangle(VALID_COORDINATES);
//        verifyNoMoreInteractions(reader, parser, creator, validator);
//    }

}