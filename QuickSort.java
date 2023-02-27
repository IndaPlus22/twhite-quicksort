public class QuickSort {

    private static final int INSERTION_SORT_THRESHOLD = 55;

    // Sorts the subarray arr[lo..hi] using quicksort.
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    
    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, lo, hi);
            return;
        }
    

        int pivotIndex = medianOfThree(arr, lo, hi);
        int pivotValue = arr[pivotIndex];

        // Move pivot to end
        int i = lo - 1;
        int j = hi;

        // Partition
        while (true) {
            while (arr[++i] < pivotValue);
            while (arr[--j] > pivotValue);
            if (i >= j)  break;
            swap(arr, i, j);
        }
        
        // Move pivot to its final position
        swap(arr, i, hi);

        // Recursively sort left and right subarrays
        quickSort(arr, lo, i - 1);
        quickSort(arr, i + 1, hi);
    }

    // Sorts the subarray arr[lo..hi] using insertion sort.
    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int j = i;
            while (j > lo && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }


    // Returns the index of the median of the three values arr[lo], arr[mid], arr[hi].
    private static int medianOfThree(int[] arr, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (arr[lo] > arr[mid]) {
            swap(arr, lo, mid);
        }
        if (arr[lo] > arr[hi]) {
            swap(arr, lo, hi);
        }
        if (arr[mid] > arr[hi]) {
            swap(arr, mid, hi);
        }
        return mid;
    }

    // Swaps the values at indices i and j in the array arr.
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
