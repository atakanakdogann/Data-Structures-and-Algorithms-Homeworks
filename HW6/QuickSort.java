import java.util.*;

public class QuickSort {

    public static < T extends Comparable < T >> void sort(T[] array) {
        quickSort(array, 0, table.length - 1);
    }
    private static < T extends Comparable < T >> void quickSort(T[] array,int first,int last) {
        if (first < last) {
            int pivIndex = partition(array, first, last);
            quickSort(array, first, pivIndex - 1);
            quickSort(array, pivIndex + 1, last);
        }
    }
    private static < T extends Comparable < T >> int partition(T[] array,int first,int last) {
        T pivot = array[first];
        int up = first;
        int down = last;
        do {
            while ( (up < last) && (pivot.compareTo(array[up]) >= 0)) {
                up++;
            }
            while (pivot.compareTo(array[down]) < 0) {
                down--;
            }
            if (up < down) {
                swap(array, up, down);
            }
        }
        while (up < down);
        swap(array, first, down);

        return down;
    }
    private static < T extends Comparable < T >> void swap(T[] arr,int first, int last) {
        T temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
  }

}
