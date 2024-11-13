package ch.hslu.ad.sw08.benchmarks;

import ch.hslu.ad.sw08.SortUtility;

public final class BubbleSortBenchmark {
    private static final int ITERATIONS = 10;
    private static final int WARMUP_ITERATIONS = 5;

    public static void main(String[] args) throws Exception {
        BenchmarkUtilities.benchmark(
                ITERATIONS,
                WARMUP_ITERATIONS,
                BubbleSortBenchmark::with100kRandomElements,
                SortUtility::bubbleSort
        );
    }

    private static Integer[] with100kRandomElements() {
        return BenchmarkUtilities.getRandomArray(100_000);
    }

    private static Integer[] with200kRandomElements() {
        return BenchmarkUtilities.getRandomArray(200_000);
    }

    private static Integer[] with400kRandomElements() {
        return BenchmarkUtilities.getRandomArray(400_000);
    }

    private static Integer[] with400kOrderedElements() {
        return BenchmarkUtilities.getOrderedArray(400_000);
    }

    private static Integer[] with400kInverseOrderedElements() {
        return BenchmarkUtilities.getInverseOrderedArray(400_000);
    }
}
