package ch.hslu.ad.sw08;

import java.util.Comparator;

public final class TriangleDistanceToOriginComparator implements Comparator<Triangle> {
    private static final Point origin = new Point(0, 0);

    @Override
    public int compare(final Triangle a, final Triangle b) {
        var centroidA = a.centroid();
        var centroidB = b.centroid();

        var distanceToOriginA = origin.distanceTo(centroidA);
        var distanceToOriginB = origin.distanceTo(centroidB);

        return Double.compare(distanceToOriginA, distanceToOriginB);
    }
}
