package ch.hslu.ad.sw01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;

public final class ComplexityCalculatorTest {
    @Test
    public void calculateComplexities() {
        final List<LongFunction<Long>> transforms = new ArrayList<>();
        transforms.add(n -> (long) Math.log(n));
        transforms.add(n -> (long) logTwoOfN(n));
        transforms.add(n ->  n * (long) Math.log(n));
        transforms.add(n -> (long) Math.pow(n, 2));
        transforms.add(n -> (long) Math.pow(n, 3));
        transforms.add(n -> (long) Math.pow(2, n));
        transforms.add(n -> (long) Math.pow(3, n));
        transforms.add(this::factorial);

        final var numbers = new long[] { 1,2,5,10,20,50,100 };

        for (var number : numbers) {
            final var row = new StringBuilder("|" + number + "|");
            for (var transform : transforms) {
                row.append(transform.apply(number)).append("|");
            }

            System.out.println(row);
        }
    }

    private double logTwoOfN(final long n) {
        return Math.log(n) / Math.log(2);
    }

    private long factorial(final long n) {
        long result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
    }
}
