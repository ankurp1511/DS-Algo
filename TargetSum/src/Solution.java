import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793};

        Arrays.sort(arr);

//        List<Integer> list = Arrays.asList(arr);
        int k = 1;
        int pairs = 0;

        for (Integer num : arr){
            if(findNum(arr, 0, arr.length -1, k + num)){
                pairs++;
            }
        }
        System.out.println(pairs);
    }


    private static boolean findNum(int[] arr, int l, int r, int x){

        if (r >= l) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == x)
                return true;

            if (arr[mid] > x)
                return findNum(arr, l, mid - 1, x);

            return findNum(arr, mid + 1, r, x);
        }
        return false;
    }
}
