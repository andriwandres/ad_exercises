package ch.hslu.ad.sw08.benchmarks;

import ch.hslu.ad.sw08.SortUtility;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class InsertionSortBenchmarkJMH {
    private Integer[] arrayWith100kElements;
    private Integer[] arrayWith200kElements;
    private Integer[] arrayWith400kElements;

    @Setup(Level.Invocation)
    public void setup() {
        arrayWith100kElements = BenchmarkUtilities.getRandomArray(100_000);
        arrayWith200kElements = BenchmarkUtilities.getRandomArray(200_000);
        arrayWith400kElements = BenchmarkUtilities.getRandomArray(400_000);
    }

    @Benchmark
    public void benchmarkInsertionSortWith100kElements() {
        SortUtility.binaryInsertionSort(arrayWith100kElements);
    }

    @Benchmark
    public void benchmarkInsertionSortWith200kElements() {
        SortUtility.binaryInsertionSort(arrayWith200kElements);
    }

    @Benchmark
    public void benchmarkInsertionSortWith400kElements() {
        SortUtility.binaryInsertionSort(arrayWith400kElements);
    }

    public static void main(String[] args) throws RunnerException {
        var options = new OptionsBuilder().build();
        new Runner(options).run();
    }
}
