import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Graph {

    public static void main(String[] args) {

        int n = 7;
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        adjList.add(null);
        adjList.add(Collections.singletonList(2));
        adjList.add(Arrays.asList(3,7));
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(3,5));
        adjList.add(Arrays.asList(4,6,7));
        adjList.add(Collections.singletonList(5));
        adjList.add(Arrays.asList(2,5));

        System.out.println(checkForCycle(adjList, visited));

    }

    private static boolean checkForCycle(List<List<Integer>> adjList, boolean[] visited) {
        for (int i = 1; i<=7 ; i++) {
            if (!visited[i]) {
                if (dfs(adjList, visited, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adjList, boolean[] visited, int node, int parent) {

        visited[node] = true;

        for (Integer num : adjList.get(node)) {
            if (!visited[num]) {
                if (dfs(adjList, visited, num, node)) {
                    return true;
                }
            } else if (num != parent) {
                return true;
            }
        }
        return false;
    }
}
