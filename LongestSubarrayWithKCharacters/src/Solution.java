import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String str = "aabacbebebe";
        Integer maxLen = longestSubstring(str, 3);
        System.out.println(maxLen);
    }

    private static int longestSubstring(String str, Integer k) {

        Map<String, Integer> map = new HashMap<>();
        int i=0, j =0;
        int maxLen = 0;
        char[] arr = str.toCharArray();

        while (j < arr.length) {
            if (!map.containsKey(String.valueOf(arr[j]))) {
                map.put(String.valueOf(arr[j]), 1);
            } else {
                map.put(String.valueOf(arr[j]), map.get(String.valueOf(arr[j])) + 1);
            }

        if (map.size() == k) {
            maxLen = j - i + 1;
        } else if (map.size() > k) {
            while (map.size() > k) {
                map.put(String.valueOf(arr[i]), map.get(String.valueOf(arr[i])) - 1);
                if(map.get(String.valueOf(arr[i])) == 0) {
                    map.remove(String.valueOf(arr[i]));
                }
                i++;
            }
        }
        j++;
        }
        return maxLen;
    }
}
