package ch.hslu.ad.sw03;

import java.util.LinkedList;

public final class CustomStack<E> implements IStack<E> {
    private final int maxSize;
    private final LinkedList<E> data = new LinkedList<>();

    public CustomStack() {
        this(Integer.MAX_VALUE);
    }

    public CustomStack(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public E pop() {
        return data.pop();
    }

    @Override
    public boolean push(E element) {
        if (size() == maxSize) {
            return false;
        }

        data.addFirst(element);
        return true;
    }

    @Override
    public int size() {
        return data.size();
    }
}
