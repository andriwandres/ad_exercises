package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Stack;

final class PostorderIterator<V extends Comparable<V>> implements Iterator<V> {
    private final Stack<BinaryTreeNode<V>> currentGraph = new Stack<>();

    public PostorderIterator(final BinaryTreeNode<V> rootNode) {
        appendLeftMostGraphFrom(rootNode);
    }

    @Override
    public boolean hasNext() {
        return !currentGraph.isEmpty();
    }

    @Override
    public V next() {
        var currentNode = currentGraph.pop();

        if (hasNext()) {
            var head = currentGraph.peek();

            assert head != null;
            if (currentNode == head.left()) {
                appendLeftMostGraphFrom(head.right());
            }
        }

        return currentNode.value();
    }

    private void appendLeftMostGraphFrom(BinaryTreeNode<V> node) {
        while (node != null) {
            currentGraph.push(node);
            var left = node.left();
            var right = node.right();

            if (left != null) {
                node = left;
            } else {
                node = right;
            }
        }
    }
}
