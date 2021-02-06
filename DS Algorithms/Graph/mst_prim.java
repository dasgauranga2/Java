import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class mst_prim {

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

    // triplet class contains all info about an edge
    // start node, end node and the edge weight
    static class Triplet {
        int start;
        int end;
        int edge_cost;

        Triplet (int s, int e, int ec) {
            start = s;
            end = e;
            edge_cost = ec;
        }

        @Override
        public String toString() {
            return "[" + start + " " + end + "]";
        }
    }

    static HashMap<Integer,List<Edge>> graph;
    static int n;
    static boolean[] visited;
    static PriorityQueue<Triplet> pq;

    // PRIM'S ALGORITHM
    // FOR MINIMUM SPANNING TREE(MST)
    // MST IS A SUBSET OF EDGES WHICH
    // CONNECTS ALL VERTICES WHILE
    // MINIMIZING THE TOTAL EDGE WEIGHT
    // TIME COMPLEXITY : 0(E*Log(E))
    public static void prim(int s) {
        
        int m = n-1;
        int edge_count = 0;
        int mst_cost = 0;
        List<Triplet> mst_edges = new LinkedList<>();

        add_edges(s);

        while (pq.size() != 0 && edge_count != m) {
            Triplet t = pq.poll();
            int node_index = t.end;

            if (visited[node_index]) {
                continue;
            }

            mst_edges.add(t);
            edge_count++;
            mst_cost = mst_cost+t.edge_cost;

            add_edges(node_index);
        }

        if (edge_count != m) {
            System.out.println("NO MST EXISTS");
        }
        else {
            System.out.println("MST COST : " + mst_cost);
            for (Triplet t : mst_edges) {
                System.out.println(t);
            }
        }
    }

    public static void add_edges(int node_index) {

        visited[node_index] = true;

        List<Edge> neighbours = graph.get(node_index);
        for (Edge e : neighbours) {
            if (!visited[e.vertex]) {
                pq.add(new Triplet(node_index, e.vertex, e.weight));
            }
        }
    }

    public static void main(String[] args) {

        // initialize a hash map
        graph = new HashMap<>();

        // we have vertices from 0 to n-1
        // for each vertex we will create an array list 
        // the array list will contain info 
        // about the edges connected to the vertex
        graph.put(0, Arrays.asList(new Edge(1,10), new Edge(2,1), new Edge(3,4)));
        graph.put(1, Arrays.asList(new Edge(0,10), new Edge(2,3), new Edge(4,0)));
        graph.put(2, Arrays.asList(new Edge(0,1), new Edge(1,3), new Edge(3,2), new Edge(5,8)));
        graph.put(3, Arrays.asList(new Edge(0,4), new Edge(2,2), new Edge(5,2), new Edge(6,7)));
        graph.put(4, Arrays.asList(new Edge(1,0), new Edge(5,1), new Edge(7,8)));
        graph.put(5, Arrays.asList(new Edge(2,8), new Edge(3,2), new Edge(4,1), new Edge(6,6), new Edge(7,9)));
        graph.put(6, Arrays.asList(new Edge(3,7), new Edge(5,6), new Edge(7,12)));
        graph.put(7, Arrays.asList(new Edge(4,8), new Edge(5,9), new Edge(6,12)));

        // n is the number of vertices in the graph
        n = graph.size();
        visited = new boolean[n];
        // initialize visited array with false values
        for (int i=0; i<n; i++) {
            visited[i] = false;
        }
        // initialize the priority queue
        pq = new PriorityQueue<>(new CustomComparator());

        prim(0);
    }

    static class CustomComparator implements Comparator<Triplet> {

        @Override
        public int compare(Triplet t1, Triplet t2) {
            if (t1.edge_cost < t2.edge_cost) {
                return -1;
            }
            else if (t1.edge_cost > t2.edge_cost) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }
}