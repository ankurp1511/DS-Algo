import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Queue<Integer> pq = new PriorityQueue<>();
        int totalCost = 0;

        pq.addAll(list);

        while (pq.size() >= 2) {
            int newRope = pq.poll() + pq.poll();
            totalCost = totalCost + newRope;
            pq.add(newRope);
        }
        System.out.println(totalCost);
    }
}
