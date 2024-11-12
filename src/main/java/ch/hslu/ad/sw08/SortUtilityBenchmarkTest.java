package ch.hslu.ad.sw08;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 2)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class SortUtilityBenchmarkTest {
    private Integer[] arrayWith100kElements;
    private Integer[] arrayWith200kElements;
    private Integer[] arrayWith400kElements;

    @Setup(Level.Invocation)
    public void setup() {
        arrayWith100kElements = getRandomArray(100_000);
        arrayWith200kElements = getRandomArray(200_000);
        arrayWith400kElements = getRandomArray(400_000);
    }

    @Benchmark
    public void benchmark_insertionSort_with100kElements() {
        SortUtility.insertionSort(arrayWith100kElements);
    }

    @Benchmark
    public void benchmark_insertionSort_with200kElements() {
        SortUtility.insertionSort(arrayWith200kElements);
    }

    @Benchmark
    public void benchmark_insertionSort_with400kElements() {
        SortUtility.insertionSort(arrayWith400kElements);
    }

    public static void main(String[] args) throws IOException, RunnerException {
        var options = new OptionsBuilder().build();
        new Runner(options).run();
    }

    private Integer[] getRandomArray(final int length) {
        return new Random(69_420)
            .ints(length, 0, length)
            .boxed()
            .toArray(Integer[]::new);
    }
}
