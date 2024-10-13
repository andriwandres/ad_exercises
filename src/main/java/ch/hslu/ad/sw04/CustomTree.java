package ch.hslu.ad.sw04;

import java.util.Collection;

public interface CustomTree<V extends Comparable<V>> extends Iterable<V> {
    boolean add(V value);
    boolean addMany(Iterable<? extends V> values);
    boolean remove(V value);
    int size();
}
