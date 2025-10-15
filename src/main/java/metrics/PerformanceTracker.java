package metrics;

public class PerformanceTracker {
    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long allocations;

    public void incrementComparisons() { comparisons++; }
    public void incrementSwaps() { swaps++; }
    public void incrementArrayAccesses(int count) { arrayAccesses += count; }
    public void incrementAllocations(int count) { allocations += count; }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public long getAllocations() { return allocations; }

    @Override
    public String toString() {
        return String.format(
                "Comparisons: %d, Swaps: %d, Array Accesses: %d, Allocations: %d",
                comparisons, swaps, arrayAccesses, allocations
        );
    }
}

