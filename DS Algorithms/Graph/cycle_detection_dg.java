import java.util.*;

public class cycle_detection_dg {

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

    static HashSet<Integer> grey;
    static HashSet<Integer> black;

    // CYCLE DETECTION FOR DIRECTED GRAPH
    // WE USE DEPTH-FIRST SEARCH
    public static void dfs(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;
        // mark the current node as grey
        // this means that we are currently traversing this vertex
        // and exploring it's neighbours
        grey.add(i);

        List<Edge> neighbours = graph.get(i);
        for (Edge e : neighbours) {
            // if a neighbour is grey it means that 
            // it is still being traversed
            // therefore, a cycle exists in the graph
            if (grey.contains(e.vertex)) {
                System.out.println("CYCLE EXISTS");
            }
            dfs(e.vertex);
        }

        // mark the node as black
        // this means that we are done traversing the current vertex
        grey.remove(i);
        black.add(i);
    }

    public static void main(String[] args) {

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(0, Arrays.asList(new Edge(1,1), new Edge(2,1)));
        graph.put(1, Arrays.asList(new Edge(2,1)));
        graph.put(2, Arrays.asList(new Edge(3,1)));
        graph.put(3, Arrays.asList());

        // n is the number of vertices in the graph
        n = graph.size();
        visited = new boolean[n];
        // initialize visited array with false values
        for (int i=0; i<n; i++) {
            visited[i] = false;
        }
        
        // initialize the hash sets
        grey = new HashSet<>();
        black = new HashSet<>();
        // do a DFS traversal with all vertices
        for (int i=0; i<n; i++) {
            // nodes marked as black have been traversed
            if (!black.contains(i)) {
                dfs(i);
            }
        }
    }
}