package algorithms;

import metrics.PerformanceTracker;


public class SelectionSort {


    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            swapped = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses(2);
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    swapped = true;
                }
            }

            // Early termination: if no smaller element found, array might be sorted
            if (!swapped && isSorted(arr, i, tracker)) {
                break;
            }

            if (minIndex != i) {
                swap(arr, i, minIndex, tracker);
            }
        }
    }

    private static boolean isSorted(int[] arr, int from, PerformanceTracker tracker) {
        for (int k = from; k < arr.length - 1; k++) {
            tracker.incrementComparisons();
            tracker.incrementArrayAccesses(2);
            if (arr[k] > arr[k + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j, PerformanceTracker tracker) {
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses(4);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
