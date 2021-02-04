import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class shortest_path_bellman_ford {

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
    static int inf;

    // BELLMAN-FORD ALGORITHM
    // SINGLE-SOURCE SHORTEST PATH ALGORITHM
    // CAN BE USED FOR GRAPHS WITH NEGATIVE EDGE WEIGHTS
    // TIME COMPLEXITY : 0(EV)
    public static int[] bellman_ford(int s) {
        
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            d[i] = inf;
        }
        d[s] = 0;

        for (int i=0; i<n-1; i++) {

            for (Integer j : graph.keySet()) {
                List<Edge> neighbours = graph.get(j);

                for (Edge e : neighbours) {
                    if (d[j] + e.weight < d[e.vertex]) {
                        d[e.vertex] = d[j] + e.weight;
                    }
                }
            }
        }

        // detect negative cycles
        for (int i=0; i<n-1; i++) {

            for (Integer j : graph.keySet()) {
                List<Edge> neighbours = graph.get(j);

                for (Edge e : neighbours) {
                    if (d[j] + e.weight < d[e.vertex]) {
                        d[e.vertex] = -inf;
                    }
                }
            }
        }

        return d;
    }

    public static void main(String[] args) {

        inf = 10000;

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(0, Arrays.asList(new Edge(1,4), new Edge(7,8)));
        graph.put(1, Arrays.asList(new Edge(0,4), new Edge(2,8), new Edge(7,11)));
        graph.put(2, Arrays.asList(new Edge(1,8), new Edge(3,7), new Edge(5,4), new Edge(8,2)));
        graph.put(3, Arrays.asList(new Edge(2,7), new Edge(4,9), new Edge(5,14)));
        graph.put(4, Arrays.asList(new Edge(3,9), new Edge(5,10)));
        graph.put(5, Arrays.asList(new Edge(2,4), new Edge(3,14), new Edge(4,10), new Edge(6,2)));
        graph.put(6, Arrays.asList(new Edge(5,2), new Edge(7,1), new Edge(8,6)));
        graph.put(7, Arrays.asList(new Edge(0,8), new Edge(1,11), new Edge(6,1), new Edge(8,7)));
        graph.put(8, Arrays.asList(new Edge(2,2), new Edge(6,6), new Edge(7,7)));


        // n is the number of vertices in the graph
        n = graph.size();
        visited = new boolean[n];
        // initialize visited array with false values
        for (int i=0; i<n; i++) {
            visited[i] = false;
        }

        int[] distances = bellman_ford(0);
        for (int i=0; i<n; i++) {
            System.out.println("NODE : " + i + "\tDISTANCE : " + distances[i]);
        }
    }
}