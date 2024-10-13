package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Stack;

final class InorderIterator<V extends Comparable<V>> implements Iterator<V> {
    private final Stack<BinaryTreeNode<V>> currentGraph = new Stack<>();

    public InorderIterator(final BinaryTreeNode<V> rootNode) {
        moveLeft(rootNode);
    }

    @Override
    public boolean hasNext() {
        return !currentGraph.isEmpty();
    }

    @Override
    public V next() {
        var currentNode = currentGraph.pop();

        var right = currentNode.right();
        if (right != null) {
            moveLeft(right);
        }

        return currentNode.value();
    }

    private void moveLeft(final BinaryTreeNode<V> node) {
        var currentNode = node;
        while(currentNode != null) {
            currentGraph.push(currentNode);
            currentNode = currentNode.left();
        }
    }
}
