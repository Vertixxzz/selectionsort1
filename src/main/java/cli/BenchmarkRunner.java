package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 1000;
        int[] arr = generateRandomArray(n);
        PerformanceTracker tracker = new PerformanceTracker();

        long start = System.nanoTime();
        SelectionSort.sort(arr, tracker);
        long end = System.nanoTime();

        System.out.println("Array sorted: " + isSorted(arr));
        System.out.println("Input size: " + n);
        System.out.println(tracker);
        System.out.printf("Execution time: %.3f ms%n", (end - start) / 1e6);
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = random.nextInt(n * 10);
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }
}
