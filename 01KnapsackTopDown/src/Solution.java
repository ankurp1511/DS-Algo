public class Solution {

    public static void main(String[] args) {

        int[] weight = new int[]{2,8,1,3};
        int[] value = new int[]{8,8,4,3};
        int w = 9;
        int n = weight.length;

        int[][] arr = new int[n+1][w+1];

        for(int i = 0 ; i < n + 1; i++){
            for(int j = 0; j < w +1; j++){
                arr[i][j] = -1;
            }
        }

        System.out.println(solve(weight, value, w, n, arr));
    }

    private static int solve(int[] weight, int[] value, int w, int n, int[][] arr) {

        if(n == 0 || w==0){
            return 0;
        }
        if(arr[n][w] != -1){
            return arr[n][w];
        }
        if(weight[n-1] <= w){
            return arr[n][w] = Math.max(value[n-1] + solve(weight, value, w - weight[n-1], n-1, arr), solve(weight, value, w, n-1, arr));
        }else {
            return arr[n][w] = solve(weight, value, w, n-1, arr);
        }
    }
}
