package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class TriangleTest {
    @Test
    public void circumference_shouldCalculateCircumference() {
        var pointA = new Point(1, 1);
        var pointB = new Point (1, 2);
        var pointC = new Point(2, 1);
        var triangle = new Triangle(pointA, pointB, pointC);

        var circumference = triangle.circumference();

        assertEquals(3.41421, circumference, 1e-5);
    }

    @Test
    public void centroid_shouldCalculateCenterPoint() {
        var pointA = new Point(1, 1);
        var pointB = new Point (1, 2);
        var pointC = new Point(2, 1);
        var triangle = new Triangle(pointA, pointB, pointC);

        var centroid = triangle.centroid();

        assertNotNull(centroid);
        assertEquals(1.33333, centroid.x(), 1e-5);
        assertEquals(1.33333, centroid.y(), 1e-5);
    }

    @Test
    public void triangles_shouldOrderByDistanceToOrigin_byDefault() {
        var closest = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        var medium = new Triangle(new Point(3, 3), new Point(3, 6), new Point(6, 3));
        var farthest = new Triangle(new Point(6, 6), new Point(6, 12), new Point(12, 6));

        Triangle[] triangles = { farthest, closest, medium };

        Arrays.sort(triangles);

        assertEquals(closest, triangles[0]);
        assertEquals(medium, triangles[1]);
        assertEquals(farthest, triangles[2]);
    }
}
