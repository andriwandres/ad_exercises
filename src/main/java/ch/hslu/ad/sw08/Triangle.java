package ch.hslu.ad.sw08;

public record Triangle(Point a, Point b, Point c) implements Comparable<Triangle> {
    @Override
    public int compareTo(Triangle other) {
        return Double.compare(circumference(), other.circumference());
    }

    public double circumference() {
        var distanceAB = a.distanceTo(b);
        var distanceAC = a.distanceTo(c);
        var distanceBC = b.distanceTo(c);

        return distanceAB + distanceAC + distanceBC;
    }
}
