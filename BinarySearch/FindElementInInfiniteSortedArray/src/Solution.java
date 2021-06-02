public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int index = findElement(arr, 1);
        System.out.println(index);
    }

    private static int findElement(int[] arr, int num) {

        int start = 0, end = 1;

        while (arr[end] < num) {
            start = end;
            end = end * 2;
        }

        return BS(arr, start, end, num);
    }

    private static int BS(int[] arr, int start, int end, int num) {

        int mid;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (arr[mid] == num) {
                return mid;
            } else if (num < arr[mid]){
                end = mid - 1;
            } else if (num > arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
