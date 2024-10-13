package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Stack;

final class PreorderIterator<V extends Comparable<V>> implements Iterator<V> {
    private final Stack<BinaryTreeNode<V>> stack = new Stack<>();

    public PreorderIterator(final BinaryTreeNode<V> rootNode) {
        if (rootNode != null) {
            stack.push(rootNode);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public V next() {
        var currentNode = stack.pop();

        var right = currentNode.right();
        var left = currentNode.left();

        if (right != null) {
            stack.push(right);
        }

        if (left != null) {
            stack.push(left);
        }

        return currentNode.value();
    }
}
