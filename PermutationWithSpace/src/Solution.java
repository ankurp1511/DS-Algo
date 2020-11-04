public class Solution {

    public static void main(String[] args) {
        
        String input = "ABCD";
        String output = "A";
        
        
        solve(input.substring(1), output);
        
        
    }

    private static void solve(String input, String output) {

        if(input == null){
            System.out.println(output);
            return;
        }
        if(input.length() == 1){
            solve(null, output + "-" + input);
            solve(null, output + input);
        }else {
            solve(input.substring(1), output + "-" + input.substring(0,1));
            solve(input.substring(1), output + input.substring(0,1));
        }
    }
}
