import java.util.*;
import java.util.stream.Stream;

public class Graph {

    public static void main(String[] args) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        adjacencyList.add(null);
        adjacencyList.add(Arrays.asList(2,5));
        adjacencyList.add(Arrays.asList(1,3));
        adjacencyList.add(Arrays.asList(2,4,5));
        adjacencyList.add(Arrays.asList(3,5));
        adjacencyList.add(Arrays.asList(1,3,4));

        bfs(adjacencyList);
        System.out.println(adjacencyList);
    }

    static void bfs(List<List<Integer>> adjacencyList) {


        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size() + 1];

        for (int i=1; i<=5; i++) {
            if (!visited[i]) {

                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {

                    Integer node = queue.remove();
                    bfs.add(node);

                    for (Integer num : adjacencyList.get(node)) {
                        if (!visited[num]) {
                            queue.add(num);
                            visited[num] = true;
                        }
                    }
                }
            }
        }
        System.out.println(bfs);
        Stream.of(visited).forEach(System.out::println);
    }

}
