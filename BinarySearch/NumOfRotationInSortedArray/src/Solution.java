public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{5,6,8,11,12,15,18,2};

        int index = minIndex(arr);
        System.out.println("No. of rotation are : " + (arr.length - index));

    }

    private static int minIndex(int[] arr) {
        int N = arr.length;
        int start = 0, end = N - 1;
        int prev, next = 0;
        int mid;

        if(arr[start] <= arr[end]){
            return 0;
        }

        while (start <= end) {
            mid = start + (end - start)/2;
            prev = (mid + N - 1) % N;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                return mid;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
            if (arr[start] <= arr[end]) {
                return start;
            }
        }
        return -1;
    }
}
