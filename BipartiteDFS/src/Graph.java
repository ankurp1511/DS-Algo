import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        int n = 9;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] coloured = new int[n+1];

        for (int i=0; i<=n; i++)
            coloured[i] = -1;

        adjList.add(null);
        adjList.add(Arrays.asList(2));
        adjList.add(Arrays.asList(1,3,9));
        adjList.add(Arrays.asList(2,4));
        adjList.add(Arrays.asList(3,5));
        adjList.add(Arrays.asList(4,6,8));
        adjList.add(Arrays.asList(5,7));
        adjList.add(Arrays.asList(6));
        adjList.add(Arrays.asList(5,9));
        adjList.add(Arrays.asList(2,8));

        System.out.println(checkIfBipartite(adjList, coloured, n));
    }

    private static boolean checkIfBipartite(List<List<Integer>> adjList, int[] coloured, int n) {

        for (int i = 1; i<= n ; i++) {
            if (coloured[i] == -1) {
                if (isBipartite(adjList, coloured, i, 0)) {
                    return true;
                }
            }
        }
        return true;
    }

    private static boolean isBipartite(List<List<Integer>> adjList, int[] coloured, int node, int colour) {

        coloured[node] = colour;

        for (Integer num : adjList.get(node)) {
            if (coloured[num] == -1) {
                if (isBipartite(adjList, coloured, num, 1 - colour)){
                    return true;
                }
            } else if (coloured[num] == coloured[node]) {
                return true;
            }
        }
        return true;
    }


}
