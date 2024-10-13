package ch.hslu.ad.sw04;

import java.util.Objects;

public final class Node<V extends Comparable<V>> {
    private final V value;
    private Node<V> left;
    private Node<V> right;

    public Node(V value) {
        this.value = value;
    }

    public V value() {
        return value;
    }

    public Node<V> getLeft() {
        return left;
    }

    public Node<V> getRight() {
        return right;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public void setRight(Node<V> right) {
        this.right = right;
    }

    public boolean hasChildren() {
        return left != null || right != null;
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || (
            obj instanceof Node<?> other &&
            Objects.equals(value, other.value)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
