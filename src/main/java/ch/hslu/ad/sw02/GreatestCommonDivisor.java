package ch.hslu.ad.sw02;

public final class GreatestCommonDivisor {
    public static int recursive(final int a, final int b) {
        if (a > b) {
            return recursive(a - b, b);
        }

        if (a < b) {
            return recursive(a, b - a);
        }

        return a;
    }
}
