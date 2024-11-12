package ch.hslu.ad.sw08.benchmarks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

final class BenchmarkUtilities {
    private BenchmarkUtilities() {}

    public static long benchmark(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();

        long elapsedTime = end - start;

        return TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
    }

    public static Integer[] getRandomArray(final int length) {
        return new Random(69_420)
                .ints(length, 0, length)
                .boxed()
                .toArray(Integer[]::new);
    }
}
