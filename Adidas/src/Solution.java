import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {


    public static void main(String[] args) {

        int[] a = new int[]{0,1,2};

        Map<Integer,Integer> map = new TreeMap<>();

        for(Integer num : a){
            if (map.get(num) != null){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        List<Integer> list = map.keySet().stream().filter( num -> map.get(num).equals(num)).collect(Collectors.toList());

        if(!list.isEmpty()){
            System.out.println(list.get(list.size() - 1));
        }else {
            System.out.println(-1);
        }

    }
}
