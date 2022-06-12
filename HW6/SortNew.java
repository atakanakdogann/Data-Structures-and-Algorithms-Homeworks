public class SortNew<T extends Comparable<T>> {
    SortNew(T arr[]) {
        new_sort(arr, 0, arr.length- 1);
    }
    public static <T> int[] min_max_finder(T[] array, int first, int last, int min, int max) {
        int[] indexes = new int[2];
        indexes[0] = min;
        indexes[1] = max;
        if (first >= last)
            return indexes;
        else {
            if (first + 1 != last) {
                if (((Comparable<T>) array[min]).compareTo(array [first + 1]) > 0)
                    min = first + 1;
                if (((Comparable<T>) array[max]).compareTo(array[first+1]) < 0)
                    max = first + 1;
                return min_max_finder(array, first + 1, last, min, max);
            }
            return indexes;
        }
    }
    public static <T> int[] min_max_finder(T[] array, int first, int last) 
    {
        return min_max_finder(array, first, last, first, first);
    }
    public static <T> void swap (T[] arr, int firstValue, int secondValue) {
        var temp = arr[firstValue];
        arr[firstValue] = arr[secondValue];
        arr [secondValue] = temp;
    }
    public static <T> T[] new_sort (T[] array, int first, int last) {
        if (first >= last)
            return array;
        else {
            int [] minMax;
            minMax = min_max_finder(array, first, last);
            swap (array, first, minMax[0]);
            swap(array, last, minMax[1]);
            return new_sort(array, first + 1, last - 1);
        }
    }
}