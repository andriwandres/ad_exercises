package ch.hslu.ad.sw08;

import java.util.Objects;

public record Triangle(Point a, Point b, Point c) implements Comparable<Triangle> {
    @Override
    public int compareTo(final Triangle other) {
        return Objects.compare(this, other, new TriangleCircumferenceComparator());
    }

    public double circumference() {
        var distanceAB = a.distanceTo(b);
        var distanceAC = a.distanceTo(c);
        var distanceBC = b.distanceTo(c);

        return distanceAB + distanceAC + distanceBC;
    }
}
