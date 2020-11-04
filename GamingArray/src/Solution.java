import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        //int[] arr = new int[]{7,4,6,5,9};
        //int[] arr = new int[]{1,3,5,7,9};
        //int[] arr = new int[]{5,2,6,3,4};
        //int[] arr = new int[]{3,1};

        //List<Integer> arr = Arrays.asList(89644,17506,4432,22750,3565,71526,64287,29748,79224,82710,62105,60082,8903,6167,39579,41112,84407,88392,44651,78310,90948,7811,95123,6219,8846,77311,33393,34124,56531,41635,88998,80137,11395,84689,75359,95471,17311,97977,83875,8808,74105,83483,72018,4880,96434,59384,86542,75875,60180,17942,61123,40794,3435,26256,55865,22589,95394,24489,18761,55707,86941,43041,64087,14425,12810,51299,44832,43887,85737,30339,67341,3365,57079,49873,71282,17916,36274,46478,31480,69431,27996,61581,54078,58596,81289,85086,3974,57368,21018,37285,73439,91187,5966,33799,13540,1116);
        List<Integer> arr = Arrays.asList(3,1);
        int itr = 0;
        int len = arr.size();

        Integer max =  arr.stream().mapToInt(v -> v).max().getAsInt();
        Integer[] array = new Integer[max];
        arr.toArray(array);
        Arrays.copyOfRange(array,0,arr.indexOf(max));

        while (true){

            if(len <= 2){
                if(len == 1){
                    itr++;
                }
                else if(arr.get(0) > arr.get(1)){
                    itr++;
                }else {
                    itr += 2;
                }
                break;
            }

            int maxL = solve(0, len % 2 == 0 ? len/2 : len/2 + 1, arr);
            int maxR = solve(len % 2 == 0 ? len/2 : len/2 + 1, len , arr);

            if(arr.get(maxL) > arr.get(maxR)){
                len = maxL;
            }else {
                len = maxR;
            }
            if(len == 0){
                itr++;
                break;
            }
            itr++;
        }

        if(itr % 2 == 0){
            System.out.println("ANDY");
        }else {
            System.out.println("BOB");
        }

    }

    private static int solve(int index, int N, List<Integer> arr){

        int max;
        if(N - index == 2){
            return arr.get(index) > arr.get(index  +1) ? index : index + 1;
        }
        if(N - index == 1){
            return index;
        }

        max = solve(index + 1, N, arr);

        if(arr.get(max) > arr.get(index)){
            return max;
        }else {
            return index;
        }
    }
}
