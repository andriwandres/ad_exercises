package ch.hslu.ad.sw08;

record SortableItem(int integer) implements Comparable<SortableItem> {
    @Override
    public boolean equals(Object o) {
        return o instanceof SortableItem other && integer == other.integer;
    }

    @Override
    public int compareTo(SortableItem other) {
        return Integer.compare(integer, other.integer);
    }
}