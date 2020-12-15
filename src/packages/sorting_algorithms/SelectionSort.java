package packages.sorting_algorithms;

import java.util.ArrayList;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {

        int[] data = new int[64];

        fillArray(data);

        printArray(data);

        System.out.println("--------------------");

        sort(data);

        printArray(data);

    }

    static void sort(int[] data) {
        int i = 0;
        while (i < data.length) {
            int min = i;
            for (int x = i + 1; x < data.length; x++) {
                if (data[x] < data[min]) {
                    min = x;
                }
            }
            int temp = data[i];
            data[i] = data[min];
            data[min] = temp;
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
