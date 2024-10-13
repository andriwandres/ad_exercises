package ch.hslu.ad.sw04;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        assertTrue(tree.addMany(1, 2, 3));
        assertEquals(3, tree.size());
    }

    @Test
    public void addMany_shouldPartiallyAddValues_whenValuesArePartiallyDuplicated() {
        var tree = new CustomTreeSet<Integer>();

        assertFalse(tree.addMany(1, 2, 2, 3, 1));
        assertEquals(3, tree.size());
    }

    @Test
    public void addMany_shouldNotAddValues_whenValuesAreAllDuplicates() {
        var tree = new CustomTreeSet<Integer>();
        tree.add(1);
        tree.add(2);
        tree.add(3);

        assertFalse(tree.addMany(1, 2, 3));
        assertEquals(3, tree.size());
    }

    @Test
    public void remove_shouldNotRemoveValue_whenTreeIsEmpty() {
        var tree = new CustomTreeSet<Integer>();

        assertFalse(tree.remove(1));
        assertEquals(0, tree.size());
    }

    @Test
    public void remove_shouldNotRemoveValue_whenValueIsNotInTree() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(1, 2, 3);

        assertFalse(tree.remove(4));
        assertEquals(3, tree.size());
    }

    @Test
    public void remove_shouldRemoveValue_whenValueIsInTree() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(1, 2, 3);

        assertTrue(tree.remove(2));
        assertEquals(2, tree.size());
    }

    @Test
    public void remove_shouldFindSuccessorNode_whenRemovingInternalNodeWithOneChild() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(12, 5, 14, 3, 7, 13, 17, 1);

        tree.remove(3);

        assertFalse(tree.search(3));
        assertTrue(tree.search(1));
    }

    @Test
    public void remove_shouldFindSuccessorNode_whenRemovingInternalNodeWithTwoChildren() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(12, 5, 14, 3, 7, 13, 17, 1, 20, 18);

        tree.remove(14);

        assertFalse(tree.search(14));
        assertTrue(tree.search(13));
        assertTrue(tree.search(17));
        assertTrue(tree.search(20));
        assertTrue(tree.search(18));
    }

    @Test
    public void remove_shouldFindSuccessorNode_whenRemovingRootNodeOfComplexTree() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(12, 5, 14, 3, 7, 13, 17, 1, 20, 18);

        tree.remove(12);

        assertFalse(tree.search(12));
        assertTrue(tree.search(5));
        assertTrue(tree.search(14));
        assertTrue(tree.search(3));
        assertTrue(tree.search(7));
        assertTrue(tree.search(13));
        assertTrue(tree.search(17));
        assertTrue(tree.search(1));
        assertTrue(tree.search(20));
        assertTrue(tree.search(18));
    }

    @Test
    public void search_shouldNotFindValue_whenTheTreeIsEmpty() {
        var tree = new CustomTreeSet<Integer>();

        assertFalse(tree.search(1));
    }

    @Test
    public void search_shouldNotFindValue_whenValueIsNotInTree() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(1, 2, 3, 4);

        assertFalse(tree.search(5));
    }

    @Test
    public void search_shouldFindValue_whenValueIsInTree() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(1, 2, 3, 4);

        assertTrue(tree.search(3));
    }

    @Test
    public void preorderIterator_shouldIterateUsingPreOrder() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(6, 3, 9, 1, 4, 8, 10, 2, 5, 7);

        var iterator = tree.preorderIterator();
        var iterated = new ArrayList<Integer>();

        while(iterator.hasNext()) {
            iterated.add(iterator.next());
        }

        assertOrderEquals(iterated, 6, 3, 1, 2, 4, 5, 9, 8, 7, 10);
    }

    @Test
    public void postorderIterator_shouldIterateUsingPostOrder() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(6, 3, 9, 1, 4, 8, 10, 2, 5, 7);

        var iterator = tree.postorderIterator();
        var iterated = new ArrayList<Integer>();

        while(iterator.hasNext()) {
            iterated.add(iterator.next());
        }

        assertOrderEquals(iterated, 2, 1, 5, 4, 3, 7, 8, 10, 9, 6);
    }

    @Test
    public void inorderIterator_shouldIterateUsingInOrder() {
        var tree = new CustomTreeSet<Integer>();
        tree.addMany(6, 3, 9, 1, 4, 8, 10, 2, 5, 7);

        var iterator = tree.inorderIterator();
        var iterated = new ArrayList<Integer>();

        while(iterator.hasNext()) {
            iterated.add(iterator.next());
        }

        assertOrderEquals(iterated, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @SafeVarargs
    private <V> void assertOrderEquals(List<V> actualValues, V... expectedValues) {
        var actualOrder = actualValues
            .stream()
            .map(Object::toString)
            .collect(Collectors.joining(" "));

        var expectedOrder = Arrays
            .stream(expectedValues)
            .map(Object::toString)
            .collect(Collectors.joining(" "));

        assertEquals(expectedOrder, actualOrder);
    }
}
