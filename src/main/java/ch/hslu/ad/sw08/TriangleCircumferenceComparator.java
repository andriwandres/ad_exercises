package ch.hslu.ad.sw08;

import java.util.Comparator;

public final class TriangleCircumferenceComparator implements Comparator<Triangle> {
    @Override
    public int compare(final Triangle a, final Triangle b) {
        return Double.compare(a.circumference(), b.circumference());
    }
}
