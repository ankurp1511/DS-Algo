public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{2,5,10,30,20,40};
        int index = searchInNearlySortedArray(arr, 8);
        System.out.println(index);
    }

    //Nearly sorted array is one in which a number which is supposed to
    //be at the ith index in sorted array can be
    //present at ith or (i-1)th index or (i+1)th index
    private static int searchInNearlySortedArray(int[] arr, int num) {

        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {

            mid = start + (end - start)/2;

            if(arr[mid] == num) {
                return mid;
            } else if (mid - 1 >= 0 && num == arr[mid - 1]) {
                return mid - 1;
            } else if (mid + 1 <= end && num == arr[mid + 1]) {
                return mid + 1;
            } else if (num <= arr[mid]) {
                end = mid - 2;
            } else if (num >= arr[mid]) {
                start = mid  + 2;
            }
        }
        return -1;
    }


}
