package metrics;

import java.io.FileWriter;
import java.io.IOException;

public class Metrics {
    private long comparisons = 0;
    private long start;

    public void startTimer() { start = System.nanoTime(); }
    public void compare() { comparisons++; }
    public long getComparisons() { return comparisons; }
    public long getElapsedNs() { return System.nanoTime() - start; }

    public void exportCSV(String file, int n) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(n + "," + getElapsedNs() + "," + getComparisons() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}