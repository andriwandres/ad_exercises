package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SortUtilityTest {
    @Test
    public void insertionSort_shouldSortArrayOfIntegers() {
        var array = new Integer[] { 5, 3, 8, 4, 2 };

        SortUtility.insertionSort(array);

        assertOrderEquals(array, 1, 2, 3, 4, 5);
    }

    @SafeVarargs
    private <V> void assertOrderEquals(V[] actualValues, V... expectedValues) {
        var actualOrder = Arrays.toString(actualValues);
        var expectedOrder = Arrays.toString(expectedValues);

        assertEquals(expectedOrder, actualOrder);
    }
}
