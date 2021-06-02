public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int index = findElement(arr, 1);
        System.out.println(index);
    }

    private static int findElement(int[] arr, int num) {

        int start = 0, end = 1;

        while (arr[end] < num) {
            start = end;
            end = end * 2;
        }

        return firstOccurence(arr, start, end, num);
    }

    private static int firstOccurence(int[] arr, int start, int end, int num) {

        int mid;
        int answer = 0;

        while (start <= end) {
            mid = start + (end - start)/2;

            if (arr[mid] == num) {
                answer = mid;
                end = mid - 1;
            } else if (arr[mid] < num) {
                start = mid + 1;
            } else if (arr[mid] > num) {
                end = mid - 1;
            }
        }
        return answer;
    }
}
