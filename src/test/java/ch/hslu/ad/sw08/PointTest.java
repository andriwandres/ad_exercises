package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class PointTest {
    @Test
    public void distanceTo_shouldCalculateDistanceBetweenTwoPoints_whenPointsAreAboveEachOther() {
        var above = new Point(1, 2);
        var below = new Point(1, 1);

        var distanceA = above.distanceTo(below);
        var distanceB = below.distanceTo(above);

        assertEquals(distanceA, distanceB);
        assertEquals(1, distanceA);
    }

    @Test
    public void distanceTo_shouldCalculateDistanceBetweenTwoPoints_whenPointsAreNextToEachOther() {
        var left = new Point(1, 1);
        var right = new Point(2, 1);

        var distanceA = left.distanceTo(right);
        var distanceB = right.distanceTo(left);

        assertEquals(distanceA, distanceB);
        assertEquals(1, distanceA);
    }

    @Test
    public void distanceTo_shouldCalculateDistanceBetweenTwoPoints_whenPointsAreDiagonalToEachOther() {
        var bottomLeft = new Point(1, 1);
        var topRight = new Point(2, 2);

        var distanceA = bottomLeft.distanceTo(topRight);
        var distanceB = topRight.distanceTo(bottomLeft);

        assertEquals(distanceA, distanceB);
        assertEquals(1.41421, distanceA, 1e-5);
    }
}
