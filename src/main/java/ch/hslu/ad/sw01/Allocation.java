package ch.hslu.ad.sw01;

public record Allocation(int address, int size) implements Comparable<Allocation> {
    @Override
    public int compareTo(final Allocation other) {
        return Integer.compare(address, other.address);
    }

    @Override
    public String toString() {
        return String.format("Allocation[Address:%d; Size:%d]", address, size);
    }
}
