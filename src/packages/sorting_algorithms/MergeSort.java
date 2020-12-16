package packages.sorting_algorithms;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        ArrayUtils arr = new ArrayUtils();
        arr.fillArray(data);
        arr.printArray(data);
        System.out.println("--------------------");
        sort(data, 0, data.length - 1);
        arr.printArray(data);
    }

    static void sort(int[] data, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        sort(data, left, middle);
        sort(data, middle + 1, right);
        merge(data, left, middle, right);
    }

    static void merge(int[] data, int left, int middle, int right) {

        int[] result = Arrays.copyOf(data, data.length);
        int i = left;
        int j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (result[i] <= result[j]) {
                data[k] = result[i];
                i++;
            } else {
                data[k] = result[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            data[k] = result[i];
            k++;
            i++;
        }
    }
}
