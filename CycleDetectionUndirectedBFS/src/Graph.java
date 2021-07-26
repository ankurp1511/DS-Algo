import java.util.*;

public class Graph {

    static class Node{
        int data;
        int parent;

        public int getData() {
            return data;
        }

        public int getParent() {
            return parent;
        }

        public Node(int data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {

        int n = 9;
        List<List<Integer>> adjList = new ArrayList<>();

        adjList.add(null);
        adjList.add(Collections.singletonList(2));
        adjList.add(Arrays.asList(3,9));
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(3,5));
        adjList.add(Arrays.asList(4,6,8));
        adjList.add(Arrays.asList(5,7));
        adjList.add(Collections.singletonList(6));
        adjList.add(Arrays.asList(5,9));
        adjList.add(Arrays.asList(2,8));

        boolean[] visited = new boolean[n+1];

        System.out.println(bfs(adjList, visited, n));

    }

    private static boolean bfs(List<List<Integer>> adjList, boolean[] visited, int n) {

        for (int i=1; i<=n ; i++) {
            if (!visited[i]) {

                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(1, -1));
                visited[1] = true;

                while (!queue.isEmpty()) {
                    Node node1 = queue.poll();
                    for (Integer num: adjList.get(node1.getData())) {
                        if (!visited[num]) {
                            queue.add(new Node(num, node1.getData()));
                            visited[num] = true;
                        } else if (num != node1.getParent()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
