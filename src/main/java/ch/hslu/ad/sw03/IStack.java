package ch.hslu.ad.sw03;

public interface IStack<E> {
    E pop();
    boolean push(E element);
    int size();
}
