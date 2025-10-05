package algorithms;

import metrics.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoyerMooreMajorityTest {

    @Test
    void testMajorityExists() {
        Metrics m = new Metrics();
        int[] arr = {2,2,1,2,3,2,2};
        assertEquals(2, BoyerMooreMajority.findMajority(arr, m));
    }

    @Test
    void testNoMajority() {
        Metrics m = new Metrics();
        int[] arr = {1,2,3,4};
        assertEquals(-1, BoyerMooreMajority.findMajority(arr, m));
    }
}