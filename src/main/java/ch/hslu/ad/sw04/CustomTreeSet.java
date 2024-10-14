package ch.hslu.ad.sw04;

import java.util.Iterator;

public final class CustomTreeSet<V extends Comparable<V>> implements CustomTree<V> {
    private BinaryTreeNode<V> rootNode;
    private int size = 0;

    @Override
    public boolean add(final V value) {
        var success = addRecursively(value, rootNode);

        if (success) {
            size++;
        }

        return success;
    }

    @SafeVarargs
    @Override
    public final boolean addMany(final V... values) {
        var hasAddedAllElements = true;
        for (var value : values) {
            if (!add(value)) {
                hasAddedAllElements = false;
            }
        }

        return hasAddedAllElements;
    }

    @Override
    public boolean remove(final V value) {
        int sizeBeforeRemoval = size;
        rootNode = removeRecursively(value, rootNode);
        return sizeBeforeRemoval != size;
    }

    @Override
    public boolean search(final V value) {
        return searchRecursively(value, rootNode);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> preorderIterator() {
        return new PreorderIterator<>(rootNode);
    }

    @Override
    public Iterator<V> postorderIterator() {
        return new PostorderIterator<>(rootNode);
    }

    @Override
    public Iterator<V> inorderIterator() {
        return new InorderIterator<>(rootNode);
    }

    @Override
    public Iterator<V> iterator() {
        return preorderIterator();
    }

    private boolean searchRecursively(final V value, final BinaryTreeNode<V> node) {
        if (node == null) {
            return false;
        }

        int comparison = value.compareTo(node.value());

        // Traverse to the left
        var left = node.left();
        if (comparison < 0 && left != null) {
            return searchRecursively(value, left);
        }

        // Traverse to the right
        var right = node.right();
        if (comparison > 0 && right != null) {
            return searchRecursively(value, right);
        }

        return comparison == 0;
    }

    private boolean addRecursively(final V value, final BinaryTreeNode<V> node) {
        if (node == null) {
            rootNode = new BinaryTreeNode<>(value);
            return true;
        }

        int comparison = value.compareTo(node.value());

        // Traverse to the left
        if (comparison < 0) {
            var left = node.left();
            if (left == null) {
                node.setLeft(new BinaryTreeNode<>(value));
                return true;
            }

            return addRecursively(value, left);
        }

        // Traverse to the right
        if (comparison > 0) {
            var right = node.right();
            if (right == null) {
                node.setRight(new BinaryTreeNode<>(value));
                return true;
            }

            return addRecursively(value, right);
        }

        // Duplicate value -> ignore
        return false;
    }

    private BinaryTreeNode<V> removeRecursively(final V value, final BinaryTreeNode<V> node) {
        // Node not found
        if (node == null) {
            return null;
        }

        int comparison = value.compareTo(node.value());

        var left = node.left();
        var right = node.right();

        // Traverse to the left
        if (comparison < 0) {
            node.setLeft(removeRecursively(value, left));
        }
        // Traverse to the right
        else if (comparison > 0) {
            node.setRight(removeRecursively(value, right));
        }
        // Override node to remove it
        else {
            size--;

            // Case 1: Node has no children
            if (!node.hasChildren()) {
                return null;
            }

            // Case 2: Node has one child
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }

            // Case 3: Node has two children:
            // Find the smallest node of right subtree (in-order successor)
            var inOrderSuccessor = findSmallestNodeFrom(node.right());

            // Replace value with successor
            var replacedNode = new BinaryTreeNode<>(inOrderSuccessor.value());
            replacedNode.setLeft(node.left());

            // Remove successor from right subtree
            replacedNode.setRight(removeRecursively(inOrderSuccessor.value(), right));
            return replacedNode;
        }

        return node;
    }

    private BinaryTreeNode<V> findSmallestNodeFrom(final BinaryTreeNode<V> node) {
        var smallestNode = node;

        while(smallestNode.left() != null) {
            smallestNode = smallestNode.left();
        }

        return smallestNode;
    }
}
