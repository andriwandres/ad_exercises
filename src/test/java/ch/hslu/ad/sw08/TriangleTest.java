package ch.hslu.ad.sw08;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void triangles_shouldOrderByCircumference_byDefault() {
        var small = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        var medium = new Triangle(new Point(3, 3), new Point(3, 6), new Point(6, 3));
        var big = new Triangle(new Point(6, 6), new Point(6, 12), new Point(12, 6));
        Triangle[] triangles = { big, small, medium };

        Arrays.sort(triangles);

        assertEquals(small, triangles[0]);
        assertEquals(medium, triangles[1]);
        assertEquals(big, triangles[2]);
    }
}
