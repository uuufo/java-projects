package packages.sorting_algorithms;

public class InsertionSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        ArrayUtils arr = new ArrayUtils();
        arr.fillArray(data);
        arr.printArray(data);
        System.out.println("--------------------");
        sort(data);
        arr.printArray(data);
    }

    static void sort(int[] data) {
        int i = 1;
        while (i < data.length) {
            int val = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > val) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = val;
            i++;
        }
    }
}
