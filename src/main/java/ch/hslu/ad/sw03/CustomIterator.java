package ch.hslu.ad.sw03;

import java.util.Iterator;

public final class CustomIterator<E> implements Iterator<E> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }
}
