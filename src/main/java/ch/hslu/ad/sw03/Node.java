package ch.hslu.ad.sw03;

final class Node<E> {
    private final E element;
    private Node<E> next;
    private Node<E> previous;

    public Node(final E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    Node<E> getNext() {
        return next;
    }

    Node<E> getPrevious() {
        return previous;
    }

    void setNext(final Node<E> node) {
        next = node;
    }

    void setPrevious(final Node<E> node) {
        previous = node;
    }
}
