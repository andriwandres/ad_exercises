package ch.hslu.ad.sw08.benchmarks;

import ch.hslu.ad.sw08.SortUtility;
import java.util.concurrent.Callable;

public final class InsertionSortBenchmarkManual {
    private static final int ITERATIONS = 10;
    private static final int WARMUP_ITERATIONS = 5;

    public static void main(String[] args) throws Exception {
        Callable<Long> task = InsertionSortBenchmarkManual::with100kRandomElements;

        System.out.println("warming up...");
        for (int i = 1; i <= WARMUP_ITERATIONS; i++) {
            System.out.println(i + "/" + WARMUP_ITERATIONS);
            task.call();
        }

        System.out.println("performing measurements...");
        for (int i = 1; i <= ITERATIONS; i++) {
            long milliseconds = task.call();
            System.out.println(i + "/" + ITERATIONS + ": Iteration took " + milliseconds + " milliseconds");
        }
    }

    private static long with100kRandomElements() {
        var array = BenchmarkUtilities.getRandomArray(100_000);
        return BenchmarkUtilities.benchmark(() -> SortUtility.insertionSort(array));
    }

    private static long with200kRandomElements() {
        var array = BenchmarkUtilities.getRandomArray(200_000);
        return BenchmarkUtilities.benchmark(() -> SortUtility.insertionSort(array));
    }

    private static long with400kRandomElements() {
        var array = BenchmarkUtilities.getRandomArray(400_000);
        return BenchmarkUtilities.benchmark(() -> SortUtility.insertionSort(array));
    }
}
