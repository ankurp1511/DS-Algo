public class Solution {

    public static void main(String[] args) {
        
        int S = 1;
        int H = 2;
        int D = 3;
        
        int N = 2;
        
        solve(S, H, D, N);
    }

    private static void solve(int s, int h, int d, int n) {

        if(n == 1){
            System.out.println("Moving " + n + "th plate from " + s + " to " + d);
            return;
        }
        solve(s, d, h, n-1);
        System.out.println("Moving " + n + "th plate from " + s + " to " + d);
        solve(h, s, d, n-1);
    }


}
