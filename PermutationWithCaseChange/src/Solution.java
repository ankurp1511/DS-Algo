public class Solution {

    public static void main(String[] args) {

        String input = "ab";
        String output = "";

        solve(input, output);

    }

    private static void solve(String input, String output) {

        if(input == null){
            System.out.println(output);
            return;
        }
        if(input.length() == 1){
            solve(null, output + input.toUpperCase());
            solve(null, output + input);
        }else {
            solve(input.substring(1), output + input.substring(0,1).toUpperCase());
            solve(input.substring(1), output + input.substring(0,1));
        }
    }
}
