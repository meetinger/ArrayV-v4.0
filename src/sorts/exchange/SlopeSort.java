/**
 * 
 */
package sorts.exchange;

import main.ArrayVisualizer;
import sorts.templates.Sort;

/**
 * @author McDude_73
 * @author EilrahcF
 *
 */
public final class SlopeSort extends Sort {

	/**
	 * @param arrayVisualizer
	 */
	public SlopeSort(ArrayVisualizer arrayVisualizer) {
		super(arrayVisualizer);
		setSortListName("Slope");
		setRunAllSortsName("Slope Sort");
		setRunSortName("Slopesort");
		setCategory("Exchange Sorts");
		setComparisonBased(true);
		setBucketSort(false);
		setRadixSort(false);
		setUnreasonablySlow(true);
		setUnreasonableLimit(16384);
		setBogoSort(false);

	}

	@Override
	public void runSort(int[] array, int length, int bucketCount) {
		for (int i = 1, j = 1; i < length; i++, j++) {
			for (int k = i - 1; k >= 0; k--, i--) {
				this.Highlights.markArray(1, i);
				this.Highlights.markArray(2, k);
				this.Delays.sleep(0.05D);
				if (this.Reads.compareValues(array[i], array[k]) < 0) {
					this.Writes.swap(array, i, k, 0.02D, true, false);
				}
			}
			i = j;
		}

	}

}
