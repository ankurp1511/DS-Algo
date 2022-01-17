public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        for (int i=0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr) {

        boolean swap = false;

        while (true) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    swap(arr, i);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
            swap = false;
        }
    }

    private static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}
