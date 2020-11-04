public class Solution {

    static String input = "abc";
    static String output = "";
    public static void main(String[] args) {
        solve(input, output);
    }

    private static void solve(String input, String output){

        if(input == null){
            System.out.println(output);
            return;
        }
        if(input.length() == 1){
            solve(null, output);
            solve(null, output + input);
        }else {
            solve(input.substring(1), output);
            solve(input.substring(1), output + input.substring(0, 1));
        }
    }
}
