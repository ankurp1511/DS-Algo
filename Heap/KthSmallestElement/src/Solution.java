import java.util.*;

public class Solution {

    static class CustomIntegerOrdering implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 < o2 ? 1 : -1;
        }
    }

    public static void main(String[] args) {

        int k = 3;
        List<Integer> list = Arrays.asList(7,10,4,3,20,15);
        Queue<Integer> pq = new PriorityQueue<>(new CustomIntegerOrdering());

        for (Integer num : list) {
            pq.add(num);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        System.out.println(pq.poll());
    }
}
