package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class AllocationTest {
    @Test
    public void allocation_shouldEquateIdenticalAllocation() {
        final var allocationA = new Allocation(16, 128);
        final var allocationB = new Allocation(16, 128);

        assertEquals(allocationA, allocationB);
    }

    @Test
    public void allocation_shouldBeOrderedByItsAddress() {
        final var allocations = List.of(
            new Allocation(3, 14),
            new Allocation(4, 10),
            new Allocation(2, 10),
            new Allocation(1, 14)
        );

        final var orderedAllocations = allocations.stream().sorted().toList();

        assertEquals(1, orderedAllocations.get(0).address());
        assertEquals(2, orderedAllocations.get(1).address());
        assertEquals(3, orderedAllocations.get(2).address());
        assertEquals(4, orderedAllocations.get(3).address());
    }

    @Test
    public void toString_shouldDisplayAddressAndSize() {
        final var allocation = new Allocation(16, 128);

        assertEquals("Allocation[Address:16; Size:128]", allocation.toString());
    }
}
