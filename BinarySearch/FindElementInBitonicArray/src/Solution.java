public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,8,12,7,5,4,2,1};
        int peakIndex = findMax(arr);
        System.out.println("max element is : " + arr[peakIndex] + " at index : " + peakIndex);
        int leftIndex = BSAscending(arr, 0, peakIndex - 1, 2);
        int rightIndex = BSDescending(arr, peakIndex, arr.length - 1, 2);

        if(leftIndex > -1) {
            System.out.println(leftIndex);
        } else {
            System.out.println(rightIndex);
        }
    }

    private static int findMax(int[] arr) {

        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (mid - 1 >= 0 && mid + 1 <= arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else if (arr[mid + 1] > arr[mid]) {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return mid;
                } else {
                    return -1;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return mid;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    private static int BSAscending(int[] arr, int start, int end, int key) {

        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else if (key < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int BSDescending(int[] arr, int start, int end, int key) {

        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                end = mid - 1;
            } else if (key < arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
