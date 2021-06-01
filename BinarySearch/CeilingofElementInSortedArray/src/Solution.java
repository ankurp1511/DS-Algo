public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,7,8,10,10,12,19};
        int ceil = ceilOfNum(arr, 9);
        System.out.println(ceil);
    }

    private static int ceilOfNum(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        int mid, answer = Integer.MAX_VALUE;

        while (start <= end) {
            mid = start + (end - start)/2;

            if(arr[mid] == num) {
                return arr[mid];
            } else if (arr[mid] > num) {
                answer = arr[mid];
                end = mid - 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            }
        }
        return answer;
    }
}
