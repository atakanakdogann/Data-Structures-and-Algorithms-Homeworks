import java.util.*;

public class MergeSort {

    public static < T extends Comparable < T >> void sort(T[] array) {
        if (array.length > 1) {
            int halfSize = array.length / 2;
            T[] leftTable = (T[])new Comparable[halfSize];
            T[] rightTable =  (T[])new Comparable[array.length - halfSize];
            System.arraycopy(array, 0, leftTable, 0, halfSize);
            System.arraycopy(array, halfSize, rightTable, 0,array.length - halfSize);

            sort(leftTable);
            sort(rightTable);

            merge(array, leftTable, rightTable);
        }
    }

    private static < T extends Comparable < T >> void merge(T[] outputSequence,T[] leftSequence,T[] rightSequence) {
        int i = 0,j = 0,k = 0; 
        while (i < leftSequence.length && j < rightSequence.length) {
            if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
                outputSequence[k++] = leftSequence[i++];
            }
            else {
                outputSequence[k++] = rightSequence[j++];
            }
        }
        while (i < leftSequence.length) {
            outputSequence[k++] = leftSequence[i++];
        }
        while (j < rightSequence.length) {
            outputSequence[k++] = rightSequence[j++];
        }
    }
}
