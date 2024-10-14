package ch.hslu.ad.sw05;

public interface CustomSet<E> {
    boolean put(E element);
    boolean remove(E element);
    boolean contains(E element);
}
