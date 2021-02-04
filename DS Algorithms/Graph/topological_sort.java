import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class topological_sort {

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
    static int[] ordering;

    // TOPOLOGICAL ORDERING
    // IT IS AN ORDERING OF THE VERTICES IN A DIRECTED GRAPH SUCH THAT
    // FOR EACH DIRECTED EDGE (u,v) 
    // THE VERTEX u APPEARS BEFORE VERTEX v
    // IN THE ORDERING
    // THERE CAN BE MULTIPLE TOPOLOGICAL ORDERINGS
    // VALID ONLY FOR DIRECTED ACYCLIC GRAPH
    // TIME COMPLEXITY : 0(V+E)
    public static void topsort() {
        
        int i = n-1;

        for (int j=0; j<n; j++) {
            if (!visited[j]) {
                List<Integer> visited_nodes = new LinkedList<>();

                dfs(j, visited_nodes);

                for (Integer v : visited_nodes) {
                    ordering[i] = v;
                    i = i-1;
                }
            }
        }
    }

    public static void dfs(int index, List<Integer> vn) {
        
        visited[index] = true;

        List<Edge> neighbours = graph.get(index);
        for (Edge e : neighbours) {
            if (!visited[e.vertex]) {
                dfs(e.vertex, vn);
            }
        }
        vn.add(index);
    }

    public static void main(String[] args) {

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(0, Arrays.asList(new Edge(1,1), new Edge(2,1)));
        graph.put(1, Arrays.asList(new Edge(2,1), new Edge(3,1)));
        graph.put(2, Arrays.asList(new Edge(3,1), new Edge(4,1)));
        graph.put(3, Arrays.asList());
        graph.put(4, Arrays.asList());

        // n is the number of vertices in the graph
        n = graph.size();
        visited = new boolean[n];
        // initialize visited array with false values
        for (int i=0; i<n; i++) {
            visited[i] = false;
        }
        ordering = new int[n];
        // initialize ordering array with zero values
        for (int i=0; i<n; i++) {
            ordering[i] = 0;
        }

        topsort();

        for (int x : ordering) {
            System.out.println(x);
        }
    }
}