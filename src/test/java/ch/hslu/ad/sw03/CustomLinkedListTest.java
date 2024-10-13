package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class CustomLinkedListTest {
    @Test
    public void getSize_shouldBeZero_whenListIsEmpty() {
        var list = new CustomLinkedList<Integer>();
        assertEquals(0, list.getSize());
    }

    @Test
    public void add_shouldAddElement() {
        var list = new CustomLinkedList<Integer>();
        list.add(42);
        assertEquals(1, list.getSize());
        list.add(69);
        assertEquals(2, list.getSize());
    }

    @Test
    public void remove_shouldRemoveElement() {
        var list = new CustomLinkedList<String>();
        list.add("A");
        list.add("B");

        assertTrue(list.remove("A"));
        assertEquals(1, list.getSize());
        assertTrue(list.remove("B"));
        assertEquals(0, list.getSize());
    }

    @Test
    public void remove_shouldNotRemove_whenElementIsNotInList() {
        var list = new CustomLinkedList<String>();
        list.add("A");
        list.add("B");

        assertFalse(list.remove("C"));
        assertEquals(2, list.getSize());
    }

    @Test
    public void iterator_shouldNotIterate_whenListIsEmpty() {
        var list = new CustomLinkedList<Integer>();
        assertFalse(list.iterator().hasNext());
    }

    @Test
    public void iterator_shouldIterate_whenListContainsElements() {
        var list = new CustomLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        var iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iterator_shouldIterateUsingForLoop() {
        var list = new CustomLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        var count = 0;
        for (var n : list) {
            count++;
        }

        assertEquals(3, count);
    }

    @Test
    public void shift_shouldRemoveFirstElement() {
        var list = new CustomLinkedList<Integer>();
        list.add(1);
        list.add(2);

        assertEquals(1, list.shift());
        assertEquals(1, list.getSize());
        assertEquals(2, list.iterator().next());
    }
}
