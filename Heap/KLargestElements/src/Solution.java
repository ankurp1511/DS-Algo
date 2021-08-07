import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {

        int k =3;
        List<Integer> list = Arrays.asList(7,4,10,3,20,15);
        Queue<Integer> pq = new PriorityQueue<>();

        for (Integer num : list) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
