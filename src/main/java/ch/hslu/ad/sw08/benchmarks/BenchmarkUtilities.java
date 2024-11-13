package ch.hslu.ad.sw08.benchmarks;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.IntStream;

final class BenchmarkUtilities {
    private BenchmarkUtilities() {}

    public static <D> void benchmark(
            final int iterations,
            final int warmups,
            final Callable<D> setup,
            final Consumer<D> task
    ) throws Exception {
        System.out.println("warming up...");

        for (int i = 1; i <= warmups; i++) {
            System.out.println(i + "/" + warmups);
            task.accept(setup.call());
        }

        System.out.println("performing measurements...");

        for (int i = 1; i <= iterations; i++) {
            final long milliseconds = measureTimeInMilliseconds(task, setup.call());
            System.out.println(i + "/" + iterations + ": Iteration took " + milliseconds + " milliseconds");
        }
    }

    public static Integer[] getRandomArray(final int length) {
        return new Random(69_420)
                .ints(length, 0, length)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static Integer[] getOrderedArray(final int length) {
        return IntStream
                .range(1, length)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static Integer[] getInverseOrderedArray(final int length) {
        return IntStream
                .range(1, length)
                .map(n -> length - n)
                .boxed()
                .toArray(Integer[]::new);
    }

    private static <D> long measureTimeInMilliseconds(Consumer<D> task, D data) {
        long start = System.nanoTime();
        task.accept(data);
        long end = System.nanoTime();

        long elapsedTime = end - start;

        return TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
    }
}
