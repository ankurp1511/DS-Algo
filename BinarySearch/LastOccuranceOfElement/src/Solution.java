public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{2,4,10,10,10,18,20};

        lastOccurance(arr, 10);

    }

    private static void lastOccurance(int[] arr, int num) {

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int lastIndex = -1;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (num == arr[mid]) {
                lastIndex = mid;
                start = mid + 1;
            }
            else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("first occurance of the num is at index : " + lastIndex);
    }

}
