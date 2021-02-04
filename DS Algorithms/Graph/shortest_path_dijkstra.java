import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class shortest_path_dijkstra {

    static class CustomComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair p1, Pair p2) {
            // elements are sorted in increasing order
            if (p1.distance < p2.distance) {
                return -1;
            }
            else if (p1.distance > p2.distance) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

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

    // pair class will contain the vertex and distance
    static class Pair {
        int vertex;
        int distance;

        Pair (int v, int d) {
            vertex = v;
            distance = d;
        }

        @Override
        public String toString() {
            return "[" + vertex + " " + distance + "]";
        }
    }

    static HashMap<Integer,List<Edge>> graph;
    static int n;
    static boolean[] visited;
    static int[] dist;

    // DIJKSTRA'S ALGORITHM
    // SINGLE SOURCE SHORTEST PATH ALGORITHM
    // FOR GRAPHS WITH NON-NEGATIVE EDGE WEIGHTS
    // TIME COMPLEXITY : 0(E*log(V))
    public static int[] dijkstra(int s) {
        
        visited = new boolean[n];
        for (int i=0; i<n; i++) {
            visited[i] = false;
        } 
        dist = new int[n];
        for (int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
        } 

        dist[s] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());
        pq.add(new Pair(s,0));

        while (pq.size() != 0) {
            Pair p = pq.poll();
            int index = p.vertex;

            visited[index] = true;
            List<Edge> neighbours = graph.get(index);
            for (Edge e : neighbours) {
                if (visited[e.vertex]) {
                    continue;
                }
                int new_dist = dist[index] + e.weight;
                if (new_dist < dist[e.vertex]) {
                    dist[e.vertex] = new_dist;
                    pq.add(new Pair(e.vertex,new_dist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

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

        n = graph.size();

        // starting vertex
        int START = 0;

        // shortest distance for each vertex from the starting vertex
        int[] distances = dijkstra(START);

        for (int i=0; i<distances.length; i++) {
            System.out.println("NODE : " + i + "\tDISTANCE : " + distances[i]);
        }
    }
}

