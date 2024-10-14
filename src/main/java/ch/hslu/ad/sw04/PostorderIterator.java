package ch.hslu.ad.sw04;

import java.util.Iterator;
import java.util.Stack;

final class PostorderIterator<V extends Comparable<V>> implements Iterator<V> {
    private final Stack<BinaryTreeNode<V>> currentGraph = new Stack<>();

    public PostorderIterator(final BinaryTreeNode<V> rootNode) {
        appendGraphDownwardsFrom(rootNode);
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
                appendGraphDownwardsFrom(head.right());
            }
        }

        return currentNode.value();
    }

    private void appendGraphDownwardsFrom(final BinaryTreeNode<V> node) {
        var currentNode = node;
        while (currentNode != null) {
            currentGraph.push(currentNode);
            var left = currentNode.left();
            var right = currentNode.right();

            if (left != null) {
                currentNode = left;
            } else {
                currentNode = right;
            }
        }
    }
}
