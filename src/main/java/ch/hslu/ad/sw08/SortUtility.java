package ch.hslu.ad.sw08;

import java.util.Arrays;

public final class SortUtility {
    private SortUtility() {}

    public static <T extends Comparable<T>> void insertionSort(final T[] array) {
        for (int i = 1; i < array.length; i++) {
            final T element = array[i];
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
            final T element = array[index];

            // Search the location where to insert the current element
            final int insertPosition = Math.abs(Arrays.binarySearch(array, 0, index, element) + 1);

            // Shift elements towards the right
            System.arraycopy(array, insertPosition, array, insertPosition + 1, index - insertPosition);

            // Insert the element at it's correct position
            array[insertPosition] = element;
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfSmallestElement = i;

            // Iterate through unsorted portion of the array and find the smallest element
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[indexOfSmallestElement]) < 0) {
                    indexOfSmallestElement = j;
                }
            }

            // Swap element with the smallest element of the unsorted portion
            final T temporary = array[i];
            array[i] = array[indexOfSmallestElement];
            array[indexOfSmallestElement] = temporary;
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    // Swap elements
                    T temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                    swapped = true;
                }
            }

            // If there are no swaps, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static <T extends Comparable<T>> void shellSort(final T[] array)
    {
        final int length = array.length;

        // Half the gap after every sorting phase
        for (int gap = length / 2; gap > 0; gap /= 2)
        {
            // Do an insertion sort with a gap
            for (int i = gap; i < length; i++)
            {
                final T temporary = array[i];
                int j = i;

                while (j >= gap && array[j - gap].compareTo(temporary) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }

                array[j] = temporary;
            }
        }
    }
}
