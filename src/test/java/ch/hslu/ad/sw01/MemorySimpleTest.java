package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class MemorySimpleTest {
    @Test
    public void toString_shouldDisplayInitialSize_whenThereIsNothingAllocated() {
        var memory = new MemorySimple(1024);

        assertEquals("MemorySimple[Belegt: 0; Frei: 1024]", memory.toString());
    }

    @Test
    public void malloc_shouldReserveMemory_whenCalledOnce() {
        var memory = new MemorySimple(1024);

        memory.malloc(16);

        assertEquals("MemorySimple[Belegt: 16; Frei: 1008]", memory.toString());
    }

    @Test
    public void malloc_shouldReserveMemory_whenCalledMultipleTimes() {
        var memory = new MemorySimple(1024);

        memory.malloc(16);
        memory.malloc(8);

        assertEquals("MemorySimple[Belegt: 24; Frei: 1000]", memory.toString());
    }

    @Test
    public void malloc_shouldThrowException_whenThereIsNotEnoughMemoryToAllocate() {
        var memory = new MemorySimple(1024);

        assertThrows(Exception.class, () -> {
            memory.malloc(2048);
        });
    }

    @Test
    public void free_shouldReleaseReservedMemory() {
        final var memory = new MemorySimple(1024);

        final var allocation = memory.malloc(16);

        memory.free(allocation);

        assertEquals("MemorySimple[Belegt: 0; Frei: 1024]", memory.toString());
    }

    @Test
    public void free_shouldThrowException_whenAllocationAddressIsNotAllocated() {
        final var memory = new MemorySimple(1024);

        assertThrows(Exception.class, () -> {
            memory.free(new Allocation(12, 16));
        });
    }
}
