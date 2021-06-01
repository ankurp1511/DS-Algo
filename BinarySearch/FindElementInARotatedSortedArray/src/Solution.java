public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{11,12,15,18,2,5,6,8};
        int numToFind = 18;
        int index = findMinIndex(arr);

        int index1 = BS(arr, 0, index - 1, numToFind);
        int index2 = BS(arr, index, arr.length - 1, numToFind);

        System.out.println(index1 < 0 ? index2: index1);
    }

    private static int findMinIndex(int[] arr) {

        int N=arr.length;
        int start=0, end=N-1;
        int prev, next;
        int mid;

        while (start <= end) {

            mid = start + (end - start)/2;
            prev = (mid - 1 + N) % N;
            next = (mid + 1) % N;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
            if(arr[start] <= arr[end]) {
                return start;
            }
        }
        return -1;
    }

    private static int BS(int[] arr, int start, int end, int num) {

        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;
            if (arr[mid] == num) {
                return mid;
            } else if (num <= arr[mid]) {
                end = mid - 1;
            } else if (num >= arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
