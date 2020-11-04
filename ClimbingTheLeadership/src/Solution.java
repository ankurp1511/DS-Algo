import java.util.*;

public class Solution {

    public static void main(String[] args) {

        List<Integer> ranked = Arrays.asList(100,90,90,80);
        List<Integer> player = Arrays.asList(70,80,105);

        Set<Integer> distinctNum = new TreeSet<>(ranked);

        for(Integer score : player){
            distinctNum.add(score);
            ranked = new ArrayList<>(distinctNum);
            System.out.println(distinctNum.size() - ranked.indexOf(score));
        }
    }
}
