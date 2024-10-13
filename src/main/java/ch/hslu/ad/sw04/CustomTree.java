package ch.hslu.ad.sw04;

import java.util.Iterator;

public interface CustomTree<V extends Comparable<V>> extends Iterable<V> {
    boolean add(V value);
    boolean addMany(V... values);
    boolean remove(V value);
    int size();
    boolean search(V value);

    Iterator<V> preorderIterator();
    Iterator<V> postorderIterator();
    Iterator<V> inorderIterator();
}
