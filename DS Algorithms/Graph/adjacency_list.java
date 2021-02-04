import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class adjacency_list {

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

    public static void main(String[] args) {

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(1, Arrays.asList(new Edge(2,4), new Edge(3,1)));
        graph.put(2, Arrays.asList(new Edge(3,6)));
        graph.put(3, Arrays.asList(new Edge(1,4), new Edge(2,1), new Edge(4,2)));
        graph.put(4, Arrays.asList());

        System.out.println(graph);
    }
}