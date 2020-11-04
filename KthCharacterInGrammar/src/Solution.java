public class Solution {

    public static void main(String[] args) {

        int K = 9;
        int N = 5;

        System.out.println(solve(N, K) ? 1 : 0);
    }

    private static boolean solve(int N, int K) {

        if(N == 1 && K == 1){
            return false;
        }

        int mid = (int) (Math.pow(2, N-1)/2);

        if(K <= mid){
            return solve(N - 1, K);
        }else {
            return !solve(N - 1, K - mid);
        }
    }
}
