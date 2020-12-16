package packages.sorting_algorithms;

import java.util.ArrayList;
import java.util.Random;

public class ArrayUtils {

    public void fillArray(int[] data) {
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

    public void printArray(int[] data) {
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
