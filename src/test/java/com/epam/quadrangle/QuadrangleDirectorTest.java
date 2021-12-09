package com.epam.quadrangle;

import com.epam.quadrangle.data.DataReader;
import com.epam.quadrangle.data.QuadrangleLineValidator;
import com.epam.quadrangle.entity.QuadrangleObservable;
import com.epam.quadrangle.exception.DataException;
import com.epam.quadrangle.exception.QuadrangleException;
import com.epam.quadrangle.logic.QuadrangleCreator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class QuadrangleDirectorTest {
    private final static String FILE_PATH = "testPath";
    private final static List<String> LIST_VALID_LINE = Arrays.asList("1 2 3");
    private final static String VALID_COORDINATES_LINE = "1 2 3";
    private final static QuadrangleObservable QUADRANGLE = Mockito.mock(QuadrangleObservable.class);

    @Test
    public void testReadShouldCreateWhenValid() throws DataException, IOException, QuadrangleException {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readValidLinesFromFile(FILE_PATH)).thenReturn(LIST_VALID_LINE);

        QuadrangleLineValidator lineValidator = Mockito.mock(QuadrangleLineValidator.class);
        when(lineValidator.isValid(VALID_COORDINATES_LINE)).thenReturn(true);

        QuadrangleCreator creator = Mockito.mock(QuadrangleCreator.class);
        when(creator.createQuadrangle(VALID_COORDINATES_LINE)).thenReturn(QUADRANGLE);

        QuadrangleDirector director = new QuadrangleDirector(reader, creator);

        //when
        List<QuadrangleObservable> quadrangles = director.read(FILE_PATH);

        //then
        Assert.assertEquals(1, quadrangles.size());
        Assert.assertEquals(quadrangles.get(0), QUADRANGLE);

        verify(reader, times(1)).readValidLinesFromFile(FILE_PATH);
        verify(creator, times(1)).createQuadrangle(VALID_COORDINATES_LINE);
        verifyNoMoreInteractions(reader, creator);
    }
}