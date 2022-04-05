public class Solution {

    public static void main(String[] args) {

        String output = "";

        print(output, 0, 0, 3);

    }

    private static void print(String output, int ones, int zeroes, int n) {

        if (n == 0) {
            if (ones > zeroes) {
                System.out.println(output);
            }
            return;
        }
        print(output + "1", ones + 1, zeroes, n-1);
        print(output + "0", ones, zeroes + 1, n-1);
    }
}
