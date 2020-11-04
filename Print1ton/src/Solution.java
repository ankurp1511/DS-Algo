public class Solution {

    public static void main(String[] args) {


        int n = 8;

        solve(n);
    }

    private static void solve(int n){

        if(n == 1){
            return;
        }
        solve(n-1);
        System.out.println(n);
    }
}
