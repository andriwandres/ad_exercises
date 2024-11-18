package ch.hslu.ad.sw08;

public record Point(double x, double y) {
    public double distanceTo(final Point otherPoint) {
        return Math.hypot(
            Math.abs(otherPoint.x - x),
            Math.abs(otherPoint.y - y)
        );
    }
}
