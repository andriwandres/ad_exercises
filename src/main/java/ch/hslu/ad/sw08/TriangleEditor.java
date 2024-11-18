package ch.hslu.ad.sw08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TriangleEditor {
    private final List<Triangle> triangles = new ArrayList<>();

    public boolean add(final Triangle triangle) {
        return triangles.add(triangle);
    }

    public boolean remove(final Triangle triangle) {
        return triangles.remove(triangle);
    }

    public void sort() {
        Collections.sort(triangles);
    }
}
