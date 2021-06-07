public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{5,10,20,15};

        int peak = findPeak(arr);
        System.out.println(peak);
    }

    private static int findPeak(int[] arr) {

        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid - 1 >= 0 && mid + 1 <= arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else if (arr[mid + 1] > arr[mid]) {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return arr[mid];
                } else {
                    return -1;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return arr[mid];
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}

