import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    private static Set<String> subsets = new TreeSet<>();

    public static void main(String[] args) {

        String input = "aac";
        String output = "";

        solve(input, output);

        subsets.forEach(System.out::println);
    }

    private static void solve(String input, String output) {

        if(input == null){
            subsets.add(output);
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
