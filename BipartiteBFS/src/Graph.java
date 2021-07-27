import java.util.*;

public class Graph {

    public static void main(String[] args) {

        int n = 9;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] coloured = new int[n+1];

        for (int i=1; i<=n; i++)
            coloured[i] = -1;

        adjList.add(null);
        adjList.add(Arrays.asList(2));
        adjList.add(Arrays.asList(3,9));
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(3,5));
        adjList.add(Arrays.asList(4,6,8));
        adjList.add(Arrays.asList(5,7));
        adjList.add(Arrays.asList(6));
        adjList.add(Arrays.asList(5,9));
        adjList.add(Arrays.asList(2,8));

        System.out.println(bipartiteBFS(adjList, coloured, n));
    }

    private static boolean bipartiteBFS(List<List<Integer>> adjList, int[] coloured, int n) {

        for (int i = 1; i<=n ; i++) {
            if (coloured[i] == -1) {

                Queue<Integer> queue = new LinkedList<>();
                queue.add(1);
                coloured[i] = 0;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();

                    for (Integer num : adjList.get(node)) {
                        if (coloured[num] == -1) {
                            queue.add(num);
                            coloured[num] = 1 - coloured[node];
                        } else if (coloured[num] == coloured[node]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
