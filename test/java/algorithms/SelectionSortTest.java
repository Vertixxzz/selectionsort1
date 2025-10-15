package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertTrue(isSorted(arr));
    }

    @Test
    void testReverseArray() {
        int[] arr = {5, 4, 3, 2, 1};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertTrue(isSorted(arr));
    }

    @Test
    void testRandomArray() {
        int[] arr = {4, 1, 3, 9, 7};
        PerformanceTracker t = new PerformanceTracker();
        SelectionSort.sort(arr, t);
        assertTrue(isSorted(arr));
    }

    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i]) return false;
        return true;
    }
}
