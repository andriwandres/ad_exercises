package ch.hslu.ad.sw03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class CustomStackTest {
    @Test
    public void size_shouldBeZero_whenStackIsEmpty() {
        var stack = new CustomStack<Integer>();
        assertEquals(0, stack.size());
    }

    @Test
    public void push_shouldAddElementToStack() {
        var stack = new CustomStack<String>();

        assertTrue(stack.push("A"));
        assertEquals(1, stack.size());

        assertTrue(stack.push("B"));
        assertEquals(2, stack.size());
    }

    @Test
    public void push_shouldNotAddElementToStack_whenMaxSizeIsReached() {
        var stack = new CustomStack<String>(1);
        assertTrue(stack.push("A"));
        assertFalse(stack.push("B"));
        assertEquals(1, stack.size());
    }

    @Test
    public void pop_shouldThrowException_whenStackIsEmpty() {
        var stack = new CustomStack<Integer>();
        assertThrows(Exception.class, stack::pop);
    }

    @Test
    public void pop_shouldRemoveLatestAddedElement() {
        var stack = new CustomStack<String>();
        stack.push("A");
        stack.push("B");

        assertEquals("B", stack.pop());
        assertEquals(1, stack.size());

        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());
    }
}
