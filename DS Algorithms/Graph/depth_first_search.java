import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class depth_first_search {

    // edge class will contain the vertex and weight
    static class Edge {
        int vertex;
        int weight;

        Edge (int v, int w) {
            vertex = v;
            weight = w;
        }

        @Override
        public String toString() {
            return "[" + vertex + " " + weight + "]";
        }
    }

    static HashMap<Integer,List<Edge>> graph;
    static int n;
    static boolean[] visited;

    // DEPTH-FIRST SEARCH
    // TIME COMPLEXITY : 0(V+E)
    public static void dfs(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        System.out.println(i);

        List<Edge> neighbours = graph.get(i);
        for (Edge e : neighbours) {
            dfs(e.vertex);
        }
    }

    public static void main(String[] args) {

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(0, Arrays.asList(new Edge(1,1), new Edge(9,1)));
        graph.put(1, Arrays.asList(new Edge(0,1), new Edge(8,1)));
        graph.put(2, Arrays.asList(new Edge(3,1)));
        graph.put(3, Arrays.asList(new Edge(2,1), new Edge(4,1), new Edge(5,1), new Edge(7,1)));
        graph.put(4, Arrays.asList(new Edge(3,1)));
        graph.put(5, Arrays.asList(new Edge(3,1), new Edge(6,1)));
        graph.put(6, Arrays.asList(new Edge(5,1), new Edge(7,1)));
        graph.put(7, Arrays.asList(new Edge(3,1), new Edge(6,1), new Edge(8,1), new Edge(10,1), new Edge(11,1)));
        graph.put(8, Arrays.asList(new Edge(1,1), new Edge(7,1), new Edge(9,1)));
        graph.put(9, Arrays.asList(new Edge(0,1), new Edge(8,1)));
        graph.put(10, Arrays.asList(new Edge(7,1), new Edge(11,1)));
        graph.put(11, Arrays.asList(new Edge(7,1), new Edge(10,1)));
        graph.put(12, Arrays.asList());


        // n is the number of vertices in the graph
        n = graph.size();
        visited = new boolean[n];
        // initialize visited array with false values
        for (int i=0; i<n; i++) {
            visited[i] = false;
        }

        dfs(0);
    }
}