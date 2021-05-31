public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,10,10,10,18,20};

        int firstOccurance = firstOccurance(arr, 10);
        if (firstOccurance != -1) {
            int lastOccurance = lastOccurance(arr, 10);
            System.out.println(lastOccurance - firstOccurance + 1);
        }

    }

    private static int firstOccurance(int[] arr, int num) {

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        int firstIndex = -1;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (num == arr[mid]) {
                firstIndex = mid;
                end = mid - 1;
            }
            else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return firstIndex;
    }

    private static int lastOccurance(int[] arr, int num) {

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
        return lastIndex;
    }

}
