public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,8,10,10,12,19};
        int floor = floorOfNum(arr, 9);
        System.out.println(floor);
    }

    private static int floorOfNum(int[] arr, int num) {

        int start = 0, end = arr.length - 1;
        int mid;
        int answer = 0;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (num == arr[mid]) {
                return arr[mid];
            } else if (arr[mid] < num) {
                answer = arr[mid];
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            }
        }
        return answer;
    }
}
