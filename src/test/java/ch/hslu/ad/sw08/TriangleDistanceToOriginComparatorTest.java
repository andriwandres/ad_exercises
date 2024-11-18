package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class TriangleDistanceToOriginComparatorTest {
    @Test
    public void triangles_shouldOrderByDistanceToOrigin_whenUsingTriangleDistanceToOriginComparator() {
        var closest = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        var medium = new Triangle(new Point(3, 3), new Point(3, 6), new Point(6, 3));
        var farthest = new Triangle(new Point(6, 6), new Point(6, 12), new Point(12, 6));

        Triangle[] triangles = { farthest, closest, medium };

        Arrays.sort(triangles, new TriangleDistanceToOriginComparator());

        assertEquals(closest, triangles[0]);
        assertEquals(medium, triangles[1]);
        assertEquals(farthest, triangles[2]);
    }
}
