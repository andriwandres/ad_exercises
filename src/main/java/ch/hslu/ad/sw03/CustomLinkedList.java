package ch.hslu.ad.sw03;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class CustomLinkedList<E> implements List<E> {
    private Node<E> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    @Override
    public boolean add(final E element) {
        var node = new Node<>(element);

        if (head == null) {
            head = node;
        } else {
            var tail = getTail();
            if (tail != null) {
                tail.setNext(node);
            }
        }

        size++;
        return true;
    }



    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        var currentNode = head;

        while (currentNode != null) {
            var next = currentNode.getNext();

            if (currentNode.getElement().equals(element)) {
                var previous = currentNode.getPrevious();
                if (previous != null) {
                    previous.setNext(next);
                }

                size--;

                return true;
            }

            currentNode = next;
        }

        return false;
    }

    public E shift() {
        var headElement = head.getElement();
        head = head.getNext();
        size--;

        return headElement;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private Node<E> getTail() {
        if (head == null) {
            return null;
        }

        var node = head;

        while(node.getNext() != null) {
            node = node.getNext();
        }

        return node;
    }

    private final class CustomIterator implements Iterator<E> {
        private Node<E> currentNode;

        @Override
        public boolean hasNext() {
            if (currentNode == null) {
                return head != null && head.getNext() != null;
            }

            return currentNode.getNext() != null;
        }

        @Override
        public E next() {
            currentNode = currentNode == null
                    ? head
                    : currentNode.getNext();

            return currentNode.getElement();
        }
    }
}
