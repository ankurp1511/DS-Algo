public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{64,25,12,22,11};
        sort(arr);

        for (int i =0; i< arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void sort(int[] arr){

        int minIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
