package packages.sorting_algorithms;

import java.util.ArrayList;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        int[] data2 = new int[64];

        fillArray(data);
        fillArray(data2);

        printArray(data);
        printArray(data2);

        System.out.println("--------------------");

        sortWhile(data);
        sortFor(data2);

        printArray(data);
        printArray(data2);

    }

    static void sortWhile(int[] data) {
        boolean changed = true;
        int count = data.length;
        while (changed) {
            changed = false;
            count--;
            for (int i = 0; i < count; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    changed = true;
                }
            }
        }
    }

    static void sortFor(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int x = 0; x < data.length - i - 1; x++) {
                if (data[x] > data[x + 1]) {
                    int temp = data[x];
                    data[x] = data[x + 1];
                    data[x + 1] = temp;
                }
            }
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
