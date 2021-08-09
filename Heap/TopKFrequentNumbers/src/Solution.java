import java.util.*;

public class Solution {

    static class Node implements Comparable<Node> {

        int freq;
        int data;

        public Node(int freq, int data) {
            this.freq = freq;
            this.data = data;
        }

        public int getFreq() {
            return freq;
        }

        public int getData() {
            return data;
        }

        @Override
        public int compareTo(Node o) {
            return o.getFreq() < this.getFreq() ? 1 : -1;
        }
    }

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,1,1,3,2,2,4);
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>();
        int k = 2;

        for (Integer num : list) {
            map.merge(num, 1, Integer::sum);
        }

        for (Integer num : map.keySet()) {
            pq.add(new Node(map.get(num), num));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll().getData());
        }
    }

}
