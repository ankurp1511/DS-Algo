import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String str = "TOTMTAPTAT";
        String pattern = "TAT";

        minimumWindow(str, pattern);
    }

    private static void minimumWindow(String str, String pattern) {

        int i =0, j=0;
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        char[] charArray = pattern.toCharArray();

        for(char s: charArray) {
            if(map.containsKey(String.valueOf(s))) {
                map.put(String.valueOf(s), map.get(String.valueOf(s)) + 1);
            } else {
                map.put(String.valueOf(s), 1);
            }
        }

        int count = map.size();

        while (j < str.length()) {

            if (map.containsKey(String.valueOf(str.charAt(j)))) {
                map.put(String.valueOf(str.charAt(j)), map.get(String.valueOf(str.charAt(j))) - 1);
                if (map.get(String.valueOf(str.charAt(j))) == 0) {
                    count--;
                }
            }

           if(count == 0) {
               answer = j - i +1;
                while (count == 0) {
                    if (map.containsKey(String.valueOf(str.charAt(i)))) {
                        map.put(String.valueOf(str.charAt(i)), map.get(String.valueOf(str.charAt(i))) + 1);
                        if(map.get(String.valueOf(str.charAt(i))) > 0) {
                            count++;
                        }
                    }
                    answer = j-i+1;
                    i++;
                }
            }
           j++;
        }
        System.out.println(answer);
    }

}
