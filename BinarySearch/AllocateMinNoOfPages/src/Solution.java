public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,40};
        int minNoOfPages = findMinPages(arr, 2);
        System.out.println(minNoOfPages);
    }

    private static int findMinPages(int[] arr, int key) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start, end;
        int mid;
        int answer = 0;

        for (int n : arr) {
            if (n > max) {
                max = n;
            }
            sum = sum + n;
        }

        start = max;
        end = sum;

        while (start <= end) {
            mid = (start + end)/2;

            if(isValid(arr, mid, key)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    private static boolean isValid(int[] arr, int maxLimit, int key) {

        int students = 1;
        int sum = 0;

        for (int j : arr) {
            if (sum + j <= maxLimit) {
                sum += j;
            } else {
                students++;
                sum = j;
                if (students > key) {
                    return false;
                }
            }
        }
        return true;
    }
}
