public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{2,4,10,10,10,18,20};

        bs(arr, 4);
    }

    private static void bs(int[] arr, int num) {

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (num == arr[mid]) {
                System.out.println("num found at index : " + mid);
                return;
            }
            else if (num < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("Number is not present in the array");
    }

}
