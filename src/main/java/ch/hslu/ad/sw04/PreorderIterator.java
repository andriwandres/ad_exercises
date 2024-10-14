package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Stack;

final class PreorderIterator<V extends Comparable<V>> implements Iterator<V> {
    private final Stack<BinaryTreeNode<V>> currentGraph = new Stack<>();

    public PreorderIterator(final BinaryTreeNode<V> rootNode) {
        if (rootNode != null) {
            currentGraph.push(rootNode);
        }
    }

    @Override
    public boolean hasNext() {
        return !currentGraph.isEmpty();
    }

    @Override
    public V next() {
        var currentNode = currentGraph.pop();

        var right = currentNode.right();
        var left = currentNode.left();

        if (right != null) {
            currentGraph.push(right);
        }

        if (left != null) {
            currentGraph.push(left);
        }

        return currentNode.value();
    }
}
