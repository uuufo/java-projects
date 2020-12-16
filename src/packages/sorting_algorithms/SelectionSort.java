package packages.sorting_algorithms;

public class SelectionSort {
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
}
