package ch.hslu.ad.sw08;

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
}
