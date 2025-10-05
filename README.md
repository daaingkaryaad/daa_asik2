# DAA Assignment 2 — Pair 3

Student A: [Ingkar Adilbek]
Group: [SE-2424]
Algorithm implemented: Boyer–Moore Majority Vote
Algorithm analyzed: Kadane's algorithm

⸻

## 1. Overview

Kadane’s Algorithm is a linear-time method to find the maximum sum of a contiguous subarray within a one-dimensional array of numbers.
It uses a dynamic-programming style recurrence that decides at each position whether to extend the current subarray or start a new one.

The implementation analyzed here also tracks simple performance metrics (comparisons and array accesses) to support empirical validation.

⸻

## 2. Implementation Summary

The analyzed project includes a KadaneAlgorithm class which:
• Iterates through the input array once.
• Maintains currentSum (best subarray sum ending at the current index) and maxSum (best overall).
• Tracks temporary start index when restarting the running sum and records final start and end indices for the maximum subarray.
• Provides a Result data structure containing maxSum, startIndex, endIndex, and the corresponding subarray.
• Includes counters for comparisonCount and arrayAccessCount (used to export metrics to CSV).

Example of the internal Result structure (simplified):

public static class Result {
public final int maxSum;
public final int startIndex;
public final int endIndex;
public final int[] subarray;


    public Result(int maxSum, int startIndex, int endIndex, int[] subarray) {
        this.maxSum = maxSum;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.subarray = subarray;
    }
}

• The implementation is single-pass (O(n) time) and uses constant extra memory (O(1) ignoring the small Result object).

⸻

## 3. Algorithm Logic (Pseudocode)

maxSum = currentSum = arr[0]
start = end = tempStart = 0

for i from 1 to n-1:
currentSum = max(arr[i], currentSum + arr[i])
if currentSum == arr[i]:
tempStart = i
if currentSum > maxSum:
maxSum = currentSum
start = tempStart
end = i

return (maxSum, start, end)

Notes:
• currentSum = max(arr[i], currentSum + arr[i]) decides whether to start a new subarray at i or continue the current one.
• tempStart is updated when we start a new subarray.
• start/end record the indices of the best subarray found so far.

⸻

## 4. Example Run

Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: maxSum = 6, start = 3, end = 6, subarray = [4, -1, 2, 1]

Explanation: The algorithm finds the contiguous subsequence from index 3 to 6 whose elements sum to 6, which is the maximum possible.

⸻

## 5. Complexity Analysis

Case Time Complexity Space Complexity Comments
Best Θ(n) O(1) Single linear pass with no extra structures
Average Θ(n) O(1) Each element visited exactly once
Worst Θ(n) O(1) Works for all-negative arrays as well

Empirical metrics (comparisons, array accesses, elapsed nanoseconds) help validate constant-factor behavior and runtime trends versus n.

⸻

## 6. Performance and Metrics

The implementation keeps counters:
• comparisonCount — number of times values are compared (e.g., currentSum > maxSum).
• arrayAccessCount — number of element reads from the input array.
• (Optionally) elapsed time in nanoseconds measured with System.nanoTime().

CSV export format used by the project:

n,elapsedNs,comparisons,arrayAccesses

This CSV can be plotted (e.g., n vs elapsedNs or n vs comparisons) to confirm linear trends.

⸻

## 7. Advantages & Limitations

Advantages
• Linear time complexity and constant extra space.
• Simple and easy to implement and reason about.
• Returns indices of the best subarray as well as the sum.

Limitations
• Only finds contiguous subarrays; not applicable for non-contiguous variants.
• For more advanced scenarios (2D arrays, constraints) algorithm must be adapted.
• Metrics depend on input distribution; adversarial inputs can change constant factors.

⸻

## 8. Conclusion

Kadane’s Algorithm is an optimal, elegant solution for the maximum contiguous subarray problem.
The provided implementation is correct, efficient (Θ(n)), and extended with simple metrics for empirical evaluation.
Using the recorded CSV results the student can confirm theoretical behavior and demonstrate empirical scaling for the assignment.

⸻

## 9. Usage (how to run & test locally)

### 1. Build and run tests:

mvn clean test

### 2. Run CLI benchmark (example):

mvn package
java -cp target/daa_asik2-1.0-SNAPSHOT.jar cli.BenchmarkRunner 10000

This runs the benchmark for n=10000 and appends a CSV line to results.csv.

⸻

## 10. References
    • Kadane, J. B. (1984). Algorithm for maximum subarray problem. Communications of the ACM.
    • Cormen, Leiserson, Rivest, Stein — Introduction to Algorithms (CLRS).
    • DAA Lecture Notes — Week 2 & Week 3.