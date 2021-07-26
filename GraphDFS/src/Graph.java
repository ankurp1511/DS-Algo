import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public static void main(String[] args) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        adjacencyList.add(null);
        adjacencyList.add(Arrays.asList(2,5));
        adjacencyList.add(Arrays.asList(1,3));
        adjacencyList.add(Arrays.asList(2,4,5));
        adjacencyList.add(Arrays.asList(3,5));
        adjacencyList.add(Arrays.asList(1,3,4));

        dfsGraph(adjacencyList);
        System.out.println(adjacencyList);
    }

    static void dfsGraph(List<List<Integer>> adjacencyList) {

        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        for (int i =1; i< adjacencyList.size(); i++) {
            if (!visited[i]) {
                dfs(i, adjacencyList, dfs, visited);
            }
        }
        System.out.println(dfs);
    }

    static void dfs(int node, List<List<Integer>> adjacencyList, List<Integer> dfs, boolean[] visited) {

        dfs.add(node);
        visited[node] = true;

        for (Integer num: adjacencyList.get(node)) {
            if (!visited[num]) {
                dfs(num, adjacencyList, dfs, visited);
            }
        }
    }
}
