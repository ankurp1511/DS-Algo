public class Solution {
    public static void main(String[] args) {

        int[] arr = new int[]{12, 11, 13, 5, 6};
        sort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }

    private static void sort(int[] arr) {

        boolean swap = false;

        for (int i=1; i< arr.length ; i++) {
            int j = i-1;
            int num = arr[i];
            while (j >= 0) {
                if (arr[j] > num) {
                    arr[j + 1] = arr[j];
                    swap = true;
                } else {
                    break;
                }
                j--;
            }
            if (swap) {
                arr[j+1] = num;
            }
        }
    }
}
