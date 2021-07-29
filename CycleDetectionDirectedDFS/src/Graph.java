import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public static void main(String[] args) {

        int N = 9;
        boolean[] visited = new boolean[N + 1];
        boolean[] dfsVisited = new boolean[N + 1];
        List<List<Integer>> adjList =  new ArrayList<>();

        adjList.add(null);
        adjList.add(Arrays.asList(2));
        adjList.add(Arrays.asList(3));
        adjList.add(Arrays.asList(4,6));
        adjList.add(Arrays.asList(5));
        adjList.add(new ArrayList<>());
        adjList.add(Arrays.asList(5));
        adjList.add(Arrays.asList(2,8));
        adjList.add(Arrays.asList(9));
        adjList.add(Arrays.asList(7));

        System.out.println(checkIfCyclic(adjList, visited, dfsVisited, N));
    }

    private static boolean checkIfCyclic(List<List<Integer>> adjList, boolean[] visited, boolean[] dfsVisited, int N) {

        for (int i =1; i<=N; i++) {
            if (!visited[i]) {
                if(isCyclic(adjList, visited, dfsVisited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCyclic(List<List<Integer>> adjList, boolean[] visited, boolean[] dfsVisited, int node) {

        visited[node] = true;
        dfsVisited[node] = true;

        for (Integer num : adjList.get(node)) {
            if (!visited[num]) {
                if (isCyclic(adjList, visited, dfsVisited, num)) {
                    return true;
                }
            } else if (visited[num] &&  dfsVisited[num]) {
                return true;
            }
        }
        dfsVisited[node] = false;
        return false;
    }
}
