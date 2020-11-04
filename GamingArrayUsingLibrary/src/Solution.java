import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5,2,6,3,4);
        int itr = 0;
        int len = arr.size();

        while (len > 0) {
            Integer max = arr.stream().mapToInt(v -> v).max().getAsInt();
            Integer[] array = new Integer[max];
            arr.toArray(array);
            if(arr.indexOf(max) == 0){
                itr++;
                break;
            }
            Integer[] resultArray = Arrays.copyOfRange(array, 0, arr.indexOf(max));
            arr = Arrays.asList(resultArray);
            len = arr.size();
            itr++;
        }

        if(itr % 2 == 0){
            System.out.println("ANDY");
        }else {
            System.out.println("BOB");
        }
    }
}
