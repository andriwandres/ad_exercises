package ch.hslu.ad.sw04;

import java.util.Objects;

final class BinaryTreeNode<V extends Comparable<V>> {
    private final V value;
    private final int hashCode;

    private BinaryTreeNode<V> left;
    private BinaryTreeNode<V> right;

    public BinaryTreeNode(V value) {
        this.value = value;
        this.hashCode = Objects.hash(value);
    }

    public V value() {
        return value;
    }

    public BinaryTreeNode<V> left() {
        return left;
    }

    public BinaryTreeNode<V> right() {
        return right;
    }

    public void setLeft(BinaryTreeNode<V> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<V> right) {
        this.right = right;
    }

    public boolean hasChildren() {
        return left != null || right != null;
    }

    @Override
    public boolean equals(final Object obj) {
        return this == obj || (
            obj instanceof BinaryTreeNode<?> other &&
            hashCode == other.hashCode
        );
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}
