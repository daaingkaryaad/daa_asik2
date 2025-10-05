package cli;

import algorithms.BoyerMooreMajority;
import metrics.Metrics;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        System.out.println("Boyer–Moore Majority Benchmark");
        System.out.println("==============================");

        int[] sizes = {100, 1000, 10000, 100000};

        Metrics.writeCSVHeader("results.csv");

        for (int n : sizes) {
            benchmark(n);
        }

        System.out.println("\nBenchmark completed. Check results.csv");
    }

    private static void benchmark(int n) {
        int[] arr = new int[n];
        Random r = new Random(42);
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(5);

        Metrics m = new Metrics();

        m.startTimer();
        BoyerMooreMajority.findMajority(arr, m);
        long elapsed = m.getElapsedNs();  // ensure timer reading
        m.exportCSV("results.csv", n);

        System.out.printf("n=%d, comparisons=%d, time=%dns%n",
                n, m.getComparisons(), elapsed);
    }
}