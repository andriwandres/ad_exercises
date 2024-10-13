package ch.hslu.ad.sw01;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public final class MemorySimple implements Memory {
    private final int totalSize;
    public final Set<Allocation> allocations = new HashSet<>();

    public MemorySimple(final int totalSize) {
        this.totalSize = totalSize;
    }

    @Override
    public Allocation malloc(final int size) {
        int startAddress = 0;

        for (var allocation : allocations) {
            if (allocation.address() - size > startAddress) {
                final var newAllocation = new Allocation(startAddress, size);
                allocations.add(newAllocation);

                return newAllocation;
            }

            startAddress = allocation.address() + allocation.size();
        }

        return null;
    }

    private Optional<Integer> findNextFreeAddress(final int size) {
        int startAddress = 0;

        return Optional.of(startAddress);
    }

    @Override
    public void free(final Allocation allocation) {
        allocations.remove(allocation);
    }

    @Override
    public String toString() {
        final var reservedMemory = getReservedMemory();
        final var freeMemory = totalSize - reservedMemory;

        return String.format("MemorySimple[Belegt: %d; Frei: %d]", reservedMemory, freeMemory);
    }

    private int getReservedMemory() {
        return allocations
                .stream()
                .map(Allocation::size)
                .reduce(0, Integer::sum);
    }
}
