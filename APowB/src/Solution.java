public class Solution {

    public static void main(String[] args) {

        int a = 2;
        int b = 50;

        System.out.println(solve(a, b));

    }

    private static long solve(int a, int b){

        if(b == 1){
            return a;
        }
        if(b == 2){
            return a * a;
        }
        if(b % 2 != 0){
            return solve(a, b/2) * solve(a, b/2) * a;
        }else {
            return solve(a, b/2) * solve(a, b/2);
        }
    }
}
