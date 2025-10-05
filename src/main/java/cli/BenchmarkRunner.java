package cli;

import algorithms.BoyerMooreMajority;
import metrics.Metrics;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = (args.length > 0) ? Integer.parseInt(args[0]) : 1000;
        int[] arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) arr[i] = r.nextInt(5);

        Metrics m = new Metrics();
        m.startTimer();
        BoyerMooreMajority.findMajority(arr, m);
        m.exportCSV("results.csv", n);

        System.out.printf("n=%d, comparisons=%d, time=%dns%n",
                n, m.getComparisons(), m.getElapsedNs());
    }
}