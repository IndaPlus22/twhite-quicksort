public class QuickSort implements IntSorter {
    private static final int INSERTION_SORT_THRESHOLD = 10;

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, lo, hi);
            return;
        }
        
        int pivotIndex = medianOfThree(arr, lo, hi);
        int pivotValue = arr[pivotIndex];

        // Move pivot to the hi end
        swap(arr, pivotIndex, hi);

        int i = lo - 1;
        int j = hi;

        while (true) {
            while (arr[++i] < pivotValue);
            while (j > lo && arr[--j] > pivotValue);
            if (i >= j) break;
            swap(arr, i, j);
        }

        // Move pivot back to its final position
        swap(arr, i, hi);

        quickSort(arr, lo, i - 1);
        quickSort(arr, i + 1, hi);
    }

    private static void insertionSort(int[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= lo && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}