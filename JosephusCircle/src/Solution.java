import java.util.ArrayList;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        int n = 1000;
        int k = 2;

        List<Integer> list = new ArrayList<>();

        for(int i=1; i <= n ; i++){
            list.add(i);
        }

        System.out.println(solve(list, k-1, 0));
    }

    private static int solve(List<Integer> list, int k, int index) {

        if(list.size() == 1){
            return list.get(0);
        }
        index = (index + k) % list.size();
        list.remove(index);
        return solve(list, k , index);
    }

}
