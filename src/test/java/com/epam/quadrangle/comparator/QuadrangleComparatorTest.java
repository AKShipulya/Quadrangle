package com.epam.quadrangle.comparator;

import com.epam.quadrangle.entity.QuadrangleObservable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class QuadrangleComparatorTest {
    private final static QuadrangleObservable QUADRANGLE_1 = Mockito.mock(QuadrangleObservable.class);
    private final static QuadrangleObservable QUADRANGLE_2 = Mockito.mock(QuadrangleObservable.class);

    @Test
    public void testQuadrangleIdComparatorShouldCompareQuadranglesById() {
        //given
        QuadrangleIdComparator comparatorEqual = Mockito.mock(QuadrangleIdComparator.class);
        when(comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(0);
        QuadrangleIdComparator comparatorFirstMore = Mockito.mock(QuadrangleIdComparator.class);
        when(comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(1);
        QuadrangleIdComparator comparatorEqualsSecondMore = Mockito.mock(QuadrangleIdComparator.class);
        when(comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualFirsMore = comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualSecondMore = comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
        verify(comparatorEqual, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorFirstMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorEqualsSecondMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verifyNoMoreInteractions(comparatorEqual);
        verifyNoMoreInteractions(comparatorFirstMore);
        verifyNoMoreInteractions(comparatorEqualsSecondMore);
    }

    @Test
    public void testQuadrangleAreaComparatorShouldCompareQuadranglesByArea() {
        //given
        QuadrangleAreaComparator comparatorEqual = Mockito.mock(QuadrangleAreaComparator.class);
        when(comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(0);
        QuadrangleAreaComparator comparatorFirstMore = Mockito.mock(QuadrangleAreaComparator.class);
        when(comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(1);
        QuadrangleAreaComparator comparatorEqualsSecondMore = Mockito.mock(QuadrangleAreaComparator.class);
        when(comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualFirsMore = comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualSecondMore = comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
        verify(comparatorEqual, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorFirstMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorEqualsSecondMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verifyNoMoreInteractions(comparatorEqual);
        verifyNoMoreInteractions(comparatorFirstMore);
        verifyNoMoreInteractions(comparatorEqualsSecondMore);
    }

    @Test
    public void testQuadranglePerimeterComparatorShouldCompareQuadranglesByPerimeter() {
        //given
        QuadranglePerimeterComparator comparatorEqual = Mockito.mock(QuadranglePerimeterComparator.class);
        when(comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(0);
        QuadranglePerimeterComparator comparatorFirstMore = Mockito.mock(QuadranglePerimeterComparator.class);
        when(comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(1);
        QuadranglePerimeterComparator comparatorEqualsSecondMore = Mockito.mock(QuadranglePerimeterComparator.class);
        when(comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualFirsMore = comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualSecondMore = comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
        verify(comparatorEqual, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorFirstMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorEqualsSecondMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verifyNoMoreInteractions(comparatorEqual);
        verifyNoMoreInteractions(comparatorFirstMore);
        verifyNoMoreInteractions(comparatorEqualsSecondMore);
    }

    @Test
    public void testQuadranglePointACoordinateXComparatorShouldCompareQuadranglesByPointACoordinateX() {
        //given
        QuadranglePointACoordinateXComparator comparatorEqual = Mockito.mock(QuadranglePointACoordinateXComparator.class);
        when(comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(0);
        QuadranglePointACoordinateXComparator comparatorFirstMore = Mockito.mock(QuadranglePointACoordinateXComparator.class);
        when(comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(1);
        QuadranglePointACoordinateXComparator comparatorEqualsSecondMore = Mockito.mock(QuadranglePointACoordinateXComparator.class);
        when(comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualFirsMore = comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualSecondMore = comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
        verify(comparatorEqual, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorFirstMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorEqualsSecondMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verifyNoMoreInteractions(comparatorEqual);
        verifyNoMoreInteractions(comparatorFirstMore);
        verifyNoMoreInteractions(comparatorEqualsSecondMore);
    }

    @Test
    public void testQuadranglePointACoordinateYComparatorShouldCompareQuadranglesByPointACoordinateY() {
        //given
        QuadranglePointACoordinateYComparator comparatorEqual = Mockito.mock(QuadranglePointACoordinateYComparator.class);
        when(comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(0);
        QuadranglePointACoordinateYComparator comparatorFirstMore = Mockito.mock(QuadranglePointACoordinateYComparator.class);
        when(comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(1);
        QuadranglePointACoordinateYComparator comparatorEqualsSecondMore = Mockito.mock(QuadranglePointACoordinateYComparator.class);
        when(comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualFirsMore = comparatorFirstMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        int actualSecondMore = comparatorEqualsSecondMore.compare(QUADRANGLE_1, QUADRANGLE_2);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
        verify(comparatorEqual, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorFirstMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verify(comparatorEqualsSecondMore, times(1)).compare(QUADRANGLE_1, QUADRANGLE_2);
        verifyNoMoreInteractions(comparatorEqual);
        verifyNoMoreInteractions(comparatorFirstMore);
        verifyNoMoreInteractions(comparatorEqualsSecondMore);
    }
}