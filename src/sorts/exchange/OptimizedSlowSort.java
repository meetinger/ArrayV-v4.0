package sorts.exchange;

import main.ArrayVisualizer;
import sorts.templates.Sort;

// Code refactored from Python: http://wiki.c2.com/?SlowSort

final public class OptimizedSlowSort extends Sort {
    public OptimizedSlowSort(ArrayVisualizer arrayVisualizer) {
        super(arrayVisualizer);

        this.setSortListName("Optimized Slow");
        this.setRunAllSortsName("Optimized Slow Sort");
        this.setRunSortName("Optimized Slowsort");
        this.setCategory("Exchange Sorts");
        this.setComparisonBased(true);
        this.setBucketSort(false);
        this.setRadixSort(false);
        this.setUnreasonablySlow(true);
        this.setUnreasonableLimit(150);
        this.setBogoSort(false);
    }

    private void optslowsort(int[] A, int i, int j) {

        if (j <= 1) return;

        optslowsort(A,i + 1, j - 1);

        if (Reads.compareValues(A[i], A[i+1]) == 1)
        {
            Delays.sleep(0.025);
            Writes.swap(A, i, i + 1, 1, true, false);

            optslowsort(A, i + 1, j);
        }

    }

    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        this.optslowsort(array, 0, currentLength - 1);
    }
}