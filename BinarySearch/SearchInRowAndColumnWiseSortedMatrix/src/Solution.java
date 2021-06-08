public class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,48},
                {32,33,39,50}};

        findIndex(arr, 45);
    }

    private static void findIndex(int[][] arr, int key) {
        int i = 0, j = arr[0].length - 1;

        while (i <= arr.length - 1 && j >= 0) {
            if (arr[i][j] == key) {
                System.out.println("Element is present at index i=" + i + " and j=" + j);
                return;
            } else if (key > arr[i][j]) {
                i++;
            } else if (key < arr[i][j]) {
                j--;
            }
        }
        System.out.println("Element is not present");
    }
}
