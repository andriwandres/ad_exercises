package ch.hslu.ad.sw04;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

public final class CustomTreeSet<V extends Comparable<V>> implements CustomTree<V> {
    private Node<V> rootNode;
    private int size = 0;

    @Override
    public boolean add(V value) {
        boolean successful = true;

        if (rootNode == null) {
            rootNode = new Node<>(value);
        } else {
            successful = addToNode(value, rootNode);
        }

        if (successful) {
            size++;
        }

        return successful;
    }

    @Override
    public boolean addMany(Iterable<? extends V> values) {
        var successful = true;
        for (var value : values) {
            if (!add(value)) {
                successful = false;
            }
        }

        return successful;
    }

    @Override
    public boolean remove(V value) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return new PreOrderTreeIterator();
    }

    private boolean addToNode(V value, Node<V> node) {
        int comparison = value.compareTo(node.value());

        // Traverse to the left
        if (comparison < 0) {
            var left = node.getLeft();
            if (left == null) {
                node.setLeft(new Node<>(value));
                return true;
            }

            return addToNode(value, left);
        }

        // Traverse to the right
        if (comparison > 0) {
            var right = node.getRight();
            if (right == null) {
                node.setRight(new Node<>(value));
                return true;
            }

            return addToNode(value, right);
        }

        // Duplicate value -> ignore
        return false;
    }

    private final class PostOrderTreeIterator implements Iterator<V> {
        private Node<V> currentNode;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public V next() {
            return null;
        }
    }

    private final class PreOrderTreeIterator implements Iterator<V> {
        private Node<V> currentNode;

        @Override
        public boolean hasNext() {
            if (currentNode == null) {
                return rootNode != null;
            }

            return currentNode.hasChildren();
        }

        @Override
        public V next() {
            if (currentNode == null) {
                return (currentNode = rootNode).value();
            }

            var leftNode = currentNode.getLeft();
            if (leftNode != null) {
                return (currentNode = leftNode).value();
            }

            var rightNode = currentNode.getRight();
            return (currentNode = rightNode).value();
        }
    }
}
