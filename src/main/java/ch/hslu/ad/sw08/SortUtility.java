package ch.hslu.ad.sw08;

import java.util.Arrays;

public final class SortUtility {
    private SortUtility() {}

    public static <T extends Comparable<T>> void insertionSort(final T[] array) {
        for (int i = 1; i < array.length; i++) {
            T element = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(element) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = element;
        }
    }

    public static <T extends Comparable<T>> void binaryInsertionSort(final T[] array) {
        for (int index = 1; index < array.length; index++) {
            T element = array[index];

            int insertPosition = Math.abs(Arrays.binarySearch(array, 0, index, element) + 1);

            System.arraycopy(array, insertPosition, array, insertPosition + 1, index - insertPosition);

            array[insertPosition] = element;
        }
    }
}
