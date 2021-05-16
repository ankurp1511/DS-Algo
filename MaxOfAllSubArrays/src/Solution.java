import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};

        List<Integer> res = solve(arr, 3);
        System.out.println(res);
    }

    private static List<Integer> solve(int[] arr, int k) {

        int i =0, j=0, max = Integer.MIN_VALUE;
        List<Integer> auxList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        while (j < arr.length) {

            if(auxList.size() > 0 && arr[j] > auxList.get(0)) {
                while (auxList.size() > 0 && auxList.get(0) < arr[j]) {
                    auxList.remove(0);
                }
                auxList.add(arr[j]);
            } else {
                auxList.add(arr[j]);
            }

            if(j - i + 1 < k) {
                j++;
            } else if(j -i + 1 == k) {
                result.add(auxList.get(0));
                if (arr[i] == auxList.get(0)) {
                    auxList.remove(0);
                }
                i++;
                j++;
            }
        }

        return result;
    }

}
