package packages.sorting_algorithms;

public class QuickSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        ArrayUtils arr = new ArrayUtils();
        arr.fillArray(data);
        arr.printArray(data);
        System.out.println("--------------------");
        sort(data, 0, data.length - 1);
        arr.printArray(data);
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
}
