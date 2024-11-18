package ch.hslu.ad.sw08.benchmarks;

import ch.hslu.ad.sw08.SortUtility;

public final class ShellSortBenchmark {
    private static final int ITERATIONS = 10;
    private static final int WARMUP_ITERATIONS = 10;

    public static void main(String[] args) throws Exception {
        BenchmarkUtilities.benchmark(
                ITERATIONS,
                WARMUP_ITERATIONS,
                ShellSortBenchmark::with100kRandomElements,
                SortUtility::shellSort
        );
    }

    private static Integer[] with100kRandomElements() {
        return BenchmarkUtilities.getRandomArray(1_000_000);
    }

    private static Integer[] with200kRandomElements() {
        return BenchmarkUtilities.getRandomArray(200_000);
    }

    private static Integer[] with400kRandomElements() {
        return BenchmarkUtilities.getRandomArray(400_000);
    }

    private static Integer[] with1mRandomElements() {
        return BenchmarkUtilities.getRandomArray(1_000_000);
    }

    private static Integer[] with400kOrderedElements() {
        return BenchmarkUtilities.getOrderedArray(400_000);
    }

    private static Integer[] with400kInverseOrderedElements() {
        return BenchmarkUtilities.getInverseOrderedArray(400_000);
    }
}
