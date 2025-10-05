package algorithms;

import metrics.Metrics;

public class BoyerMooreMajority {

    public static int findMajority(int[] nums, Metrics m) {
        int candidate = -1, count = 0;

        for (int num : nums) {
            m.compare();
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        int freq = 0;
        for (int num : nums) {
            m.compare();
            if (num == candidate) freq++;
        }

        return (freq > nums.length / 2) ? candidate : -1;
    }
}