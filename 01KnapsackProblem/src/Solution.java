public class Solution {

    public static void main(String[] args) {
        
        
        int[] weight = new int[]{2,8,1,3};
        int[] value = new int[]{8,8,4,3};
        int w = 9;
        int n = weight.length;

        System.out.println(solve(weight, value, w, n));
    }

    private static int solve(int[] weight, int[] value, int w, int n) {

        if(n == 0 || w == 0){
            return 0;
        }

        if(weight[n-1] <= w){
            return Math.max(value[n-1] + solve(weight, value, w - weight[n-1], n-1), solve(weight, value, w, n-1));
        }else {
            return solve(weight, value, w, n-1);
        }
    }
}
