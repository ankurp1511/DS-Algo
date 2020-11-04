import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,1,5,3,2,4};

        PriorityQueue

        Map<Long, Long> map = new HashMap<>();

        for (long num: arr){
            if(map.get(num) == null){
                map.put(num, 1L);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }

        List<Long> list = map.values().stream().filter(v -> v > 1).map(v ->  v* (v-1)).collect(Collectors.toList());

        if(!list.isEmpty()){
            System.out.println(list.stream().mapToLong(value -> value).sum());
        }else {
            System.out.println(0L);
        }
    }
}
