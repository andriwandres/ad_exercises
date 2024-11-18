package ch.hslu.ad.sw08;

public record Point(int x, int y) {
    public double distanceTo(final Point otherPoint) {
        return Math.hypot(
            Math.abs(otherPoint.x - x),
            Math.abs(otherPoint.y - y)
        );
    }
}
