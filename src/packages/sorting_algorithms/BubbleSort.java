package packages.sorting_algorithms;

public class BubbleSort {
    public static void main(String[] args) {

        int[] data = new int[64];
        int[] data2 = new int[64];
        ArrayUtils arr = new ArrayUtils();
        arr.fillArray(data);
        arr.fillArray(data2);
        arr.printArray(data);
        arr.printArray(data2);
        System.out.println("--------------------");
        sortWhile(data);
        sortFor(data2);
        arr.printArray(data);
        arr.printArray(data2);
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
}
