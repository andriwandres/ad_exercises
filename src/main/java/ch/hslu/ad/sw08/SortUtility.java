package ch.hslu.ad.sw08;

public final class SortUtility {
    private SortUtility() {}

    public static <T extends Comparable<T>> void insertionSort(final T[] array) {
        for (int i = 1; i < array.length; i++) {
            T element = array[i];
            int j = i;

            while (j >= 0 && array[j].compareTo(element) > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = element;
        }
    }
}
