import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int k=3;
        List<Integer> list = Arrays.asList(6,5,3,2,8,10,9);

        Queue<Integer> pq = new PriorityQueue<>();

        for (Integer num : list) {
            pq.add(num);
            if (pq.size() > k) {
                System.out.println(pq.poll());
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
