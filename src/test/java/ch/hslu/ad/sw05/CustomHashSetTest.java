package ch.hslu.ad.sw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class CustomHashSetTest {
    @Test
    public void put_shouldThrowIllegalArgumentException_whenElementIsNull() {
        var set = new CustomHashSet<Integer>();

        assertThrows(IllegalArgumentException.class, () -> set.put(null));
    }

    @Test
    public void put_shouldAddNewElement() {
        var set = new CustomHashSet<Integer>();

        set.put(12);
        set.put(14);

        assertTrue(set.contains(12));
        assertTrue(set.contains(14));
    }

    @Test
    public void put_shouldOverrideExistingElement_whenCollisionOccurs() {
        var set = new CustomHashSet<Integer>();

        set.put(1);
        set.put(11);

        assertFalse(set.contains(1));
        assertTrue(set.contains(11));
    }

    @Test
    public void remove_shouldThrowIllegalArgumentException_whenElementIsNull() {
        var set = new CustomHashSet<Integer>();

        assertThrows(IllegalArgumentException.class, () -> set.remove(null));
    }

    @Test
    public void remove_shouldNotRemoveElement_whenSetIsEmpty() {
        var set = new CustomHashSet<Integer>();

        assertFalse(set.remove(1));
    }

    @Test
    public void remove_shouldNotRemoveElement_whenElementDoesNotExistInSet() {
        var set = new CustomHashSet<Integer>();
        set.put(1);
        set.put(2);
        set.put(3);

        assertFalse(set.remove(4));
    }

    @Test
    public void contains_shouldThrowIllegalArgumentException_whenElementIsNull() {
        var set = new CustomHashSet<Integer>();

        assertThrows(IllegalArgumentException.class, () -> set.contains(null));
    }

    @Test
    public void contains_shouldReturnFalse_whenSetIsEmpty() {
        var set = new CustomHashSet<Integer>();

        assertFalse(set.contains(1));
    }

    @Test
    public void contains_shouldReturnTrue_whenElementIsContainedInSet() {
        var set = new CustomHashSet<Integer>();

        set.put(1);

        assertTrue(set.contains(1));
    }
}
