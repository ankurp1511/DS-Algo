import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String str = "pwwkew";
        Integer result = calculateMaxLength(str);
        System.out.println(result);

    }

    private static int calculateMaxLength(String str) {

        Map<String, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        char[] arr = str.toCharArray();
        int maxLength = 0;


        while (j < arr.length) {

            if(!map.containsKey(String.valueOf(arr[j]))) {
                map.put(String.valueOf(arr[j]), 1);
            } else {
                map.put(String.valueOf(arr[j]), map.get(String.valueOf(arr[j])) + 1);
            }

            if (map.size() == j - i + 1) {
                maxLength = Math.max(maxLength, j - i + 1);
            } else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    map.put(String.valueOf(arr[i]), map.get(String.valueOf(arr[i])) - 1);
                    if(map.get(String.valueOf(arr[i]))  == 0) {
                        map.remove(String.valueOf(arr[i]));
                    }
                    i++;
                }
                maxLength = Math.max(maxLength, j - i +1);
            }
            j++;
        }
        return maxLength;
    }
}
