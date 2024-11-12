package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class InsertionSortTest {
    @Test
    public void insertionSort_shouldNotChangeArray_whenArrayIsEmpty() {
        var array = new Integer[] {  };

        SortUtility.insertionSort(array);

        assertEquals(0, array.length);
    }

    @Test
    public void insertionSort_shouldNotChangeArray_whenAllElementsAreEqual() {
        var array = new Integer[] { 1, 1, 1 };

        SortUtility.insertionSort(array);

        assertOrderEquals(array, 1, 1, 1);
    }

    @Test
    public void insertionSort_shouldNotChangeArray_whenAlreadySorted() {
        var array = new Integer[] { 1, 2, 3, 4, 5 };

        SortUtility.insertionSort(array);

        assertOrderEquals(array, 1, 2, 3, 4, 5);
    }

    @Test
    public void insertionSort_shouldSortArrayOfIntegers() {
        var array = new Integer[] { 5, 3, 1, 4, 2 };

        SortUtility.insertionSort(array);

        assertOrderEquals(array, 1, 2, 3, 4, 5);
    }

    @Test
    public void insertionSort_shouldSortArrayOfObjects() {
        var array = new SortableItem[] {
            new SortableItem(3),
            new SortableItem(1),
            new SortableItem(2),
            new SortableItem(5),
            new SortableItem(4),
        };

        SortUtility.insertionSort(array);

        var integers = Arrays
            .stream(array)
            .map(SortableItem::integer)
            .toArray();

        assertOrderEquals(integers, 1, 2, 3, 4, 5);
    }

    @SafeVarargs
    private <V> void assertOrderEquals(V[] actualValues, V... expectedValues) {
        var actualOrder = Arrays.toString(actualValues);
        var expectedOrder = Arrays.toString(expectedValues);

        assertEquals(expectedOrder, actualOrder);
    }
}
