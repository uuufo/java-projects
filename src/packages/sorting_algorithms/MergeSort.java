package packages.sorting_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        fillArray(data);
        printArray(data);
        System.out.println("--------------------");
        sort(data, 0, data.length - 1);
        printArray(data);

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

    static void fillArray(int[] data) {
        ArrayList<Integer> usedNums = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < data.length; i++) {
            int y = rand.nextInt(data.length) + 1;
            while (usedNums.contains(y)) {
                y = rand.nextInt(data.length) + 1;
            }
            usedNums.add(y);
            data[i] = y;
        }
    }

    static void printArray(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
