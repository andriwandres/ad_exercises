package ch.hslu.ad.sw05;

public final class CustomHashSet<E> implements CustomSet<E> {
    private static final int CAPACITY = 10;
    private final E[] elements = (E[]) new Object[CAPACITY];

    @Override
    public boolean put(final E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        var index = getElementIndex(element);
        elements[index] = element;

        return true;
    }

    @Override
    public boolean remove(final E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        if (!contains(element)) {
            return false;
        }

        var index = getElementIndex(element);
        elements[index] = element;

        return true;
    }

    @Override
    public boolean contains(final E element) {
        if (element == null) {
            throw new IllegalArgumentException("element cannot be null");
        }

        var index = getElementIndex(element);
        var elementInSet = elements[index];
        return elementInSet != null && elementInSet.equals(element);
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();

        for (int i = 0; i < elements.length; i++) {
            var element = elements[i];
            var row = "[" + i + "] = " + element.toString() + "\n";
            stringRepresentation.append(row);
        }

        return stringRepresentation.toString();
    }

    private int getElementIndex(final E element) {
        return element.hashCode() % CAPACITY;
    }
}
