package packages.sorting_algorithms;

import java.util.ArrayList;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        fillArray(data);
        printArray(data);
        System.out.println("--------------------");
        sort(data, 0, data.length - 1);
        printArray(data);

    }

    static void sort(int[] data, int low, int high) {
        int i = low;
        int j = high;
        int pivot = data[(low + high) / 2];

        while (i <= j) {
            while (data[i] < pivot) {
                i++;
            }
            while (data[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            sort(data, low, j);
        if (i < high)
            sort(data, i, high);
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
