package theme1algo.task2;

import java.util.Arrays;
import java.util.logging.Logger;

public class MegaArray {
    private final Logger logger = Logger.getLogger(MegaArray.class.getName());
    private final int[] array;

    public MegaArray(int[] values) {
        array = values;
    }

    public void mergeSort() {
        sort(array, array.length);
    }

    private int[] sort(int[] arr, int length) {
        if (length < 2) {
            return arr;
        }
        int midIndex = length / 2;
        int[] left = new int[midIndex];
        int[] right = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            left[i] = arr[i];
        }
        for (int i = midIndex; i < length; i++) {
            right[i - midIndex] = arr[i];
        }
        sort(left, midIndex);
        sort(right, length - midIndex);

        merge(arr, left, right, midIndex, length - midIndex);
        return arr;
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < left) {
            arr[k++] = leftArr[i++];
        }
        while (j < right) {
            arr[k++] = rightArr[j++];
        }
    }

    public int binarySearch(int value) {
        return search(array, value, 0, array.length);
    }

    private int search(int[] arr, int value, int low, int high) {
        int middle = low + ((high - low) / 2);
        if (high < low) return -1;
        if (value == arr[middle]) return middle;
        else if (value < arr[middle]) return search(arr, value, low, middle - 1);
        else return search(arr, value, middle + 1, high);
    }

    public void print() {
        logger.info(Arrays.toString(array));
    }
}
