import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    static class Node implements Comparable<Node> {

        int diff;
        int data;

        public Node(int diff, int data) {
            this.diff = diff;
            this.data = data;
        }

        public int getDiff() {
            return diff;
        }

        public int getData() {
            return data;
        }

        @Override
        public int compareTo(Node o) {
            return o.getDiff() > this.getDiff() ? 1 : -1;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,6,7,8,9);

        int x = 7;
        int k = 3;

        Queue<Node> pq = new PriorityQueue<>();

        for (Integer num : list) {
            pq.add(new Node(Math.abs(x-num), num));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getData());
        }

    }
}
