package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class CustomTreeSetTest {
    @Test
    public void add_shouldAddValueToTree() {
        var tree = new CustomTreeSet<Integer>();

        assertTrue(tree.add(1));
        assertTrue(tree.add(2));
        assertEquals(2, tree.size());
    }

    @Test
    public void add_shouldNotAddValue_whenValueIsDuplicate() {
        var tree = new CustomTreeSet<Integer>();

        assertTrue(tree.add(1));
        assertFalse(tree.add(1));
        assertEquals(1, tree.size());
    }

    @Test
    public void addMany_shouldAddValuesToTree() {
        var tree = new CustomTreeSet<Integer>();

        assertTrue(tree.addMany(List.of(1, 2, 3)));
        assertEquals(3, tree.size());
    }

    @Test
    public void addMany_shouldPartiallyAddValues_whenValuesArePartiallyDuplicated() {
        var tree = new CustomTreeSet<Integer>();

        assertFalse(tree.addMany(List.of(1, 2, 2, 3, 1)));
        assertEquals(3, tree.size());
    }

    @Test
    public void addMany_shouldNotAddValues_whenValuesAreAllDuplicates() {
        var tree = new CustomTreeSet<Integer>();
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertFalse(tree.addMany(List.of(1, 2, 3)));
        assertEquals(3, tree.size());
    }

    @Test
    public void iteratorPreOrder_shouldIterateUsingPreOrder() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));


    }
}
