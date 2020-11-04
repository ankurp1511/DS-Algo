public class Solution {


    public static void main(String[] args) {

        int[] weight = new int[]{2,8,1,3};
        int[] value = new int[]{8,8,4,3};
        int w = 9;
        int n = weight.length;

        int[][] t = new int[n+1][w+1];
        System.out.println(solve(weight, value, w, n, t));
    }

    private static int solve(int[] weight, int[] value, int w, int n, int[][] t) {

        for (int i = 0; i < n+1; i++){
            for(int j = 0; j < w+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }

        for(int i = 1; i< n+1; i++){
            for(int j=1; j < w+1; j++){
                if(weight[i-1] <= j){
                    t[i][j] = Math.max(value[i-1] + t[i-1][j - weight[i-1]], t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][w];
    }
}
