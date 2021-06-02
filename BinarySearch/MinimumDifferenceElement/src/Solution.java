public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,10,15};
        int minDifference = findMinElement(arr, 14);
        System.out.println(minDifference);
    }

    private static int findMinElement(int[] arr, int num) {

        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (arr[mid] == num) {
                return arr[mid];
            } else if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            }
        }

        return Math.abs(arr[end] - num) < Math.abs(arr[start] - num)
                ? arr[end]
                : arr[start];
    }
}
