package ch.hslu.ad.sw08.benchmarks;

import ch.hslu.ad.sw08.SortUtility;

public final class BubbleSortBenchmark {
    private static final int ITERATIONS = 10;
    private static final int WARMUP_ITERATIONS = 5;

    public static void main(String[] args) throws Exception {
        BenchmarkUtilities.benchmark(
                ITERATIONS,
                WARMUP_ITERATIONS,
                BubbleSortBenchmark::with200kInverseOrderedElements,
                SortUtility::bubbleSort
        );
    }

    private static Integer[] with50kRandomElements() {
        return BenchmarkUtilities.getRandomArray(50_000);
    }

    private static Integer[] with100kRandomElements() {
        return BenchmarkUtilities.getRandomArray(100_000);
    }

    private static Integer[] with200kRandomElements() {
        return BenchmarkUtilities.getRandomArray(200_000);
    }

    private static Integer[] with200kOrderedElements() {
        return BenchmarkUtilities.getOrderedArray(200_000);
    }

    private static Integer[] with200kInverseOrderedElements() {
        return BenchmarkUtilities.getInverseOrderedArray(200_000);
    }
}
