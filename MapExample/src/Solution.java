import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Rishu", 25);
        map.put("Ruth", 24);
        map.put("Saani",28);
        map.put("Ankur", 27);
        map.put("Pappi", 12);


        Iterator itr = map.keySet().iterator();

        while (itr.hasNext()){
            String str = itr.next().toString();
            if(!str.startsWith("R") && map.get(str) < 24) {
                itr.remove();
            }
        }

        map.keySet().forEach(s -> {
            System.out.println(map.get(s));
        });
    }
}
