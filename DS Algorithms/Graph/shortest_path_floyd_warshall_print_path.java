import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class shortest_path_floyd_warshall_print_path {

    static int[][] graph;
    static int inf;
    static int n;

    // FLOYD WARSHALL ALGORITHM
    // ALL-PAIRS SHORTEST PATH ALGORITHM
    // TIME COMPLEXITY : 0(V^3)
    public static void floyd_warshall(int s,int e) {
        
        int[][] dp = new int[n][n];
        int[][] next = new int[n][n];

        // setup the arrays
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                next[i][j] = -1;
            }
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                dp[i][j] = graph[i][j];
                if (graph[i][j] != inf) {
                    next[i][j] = j;
                }
            }
        }

        // floyd warshall algorithm
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // detect negative cycles
        for (int k=0; k<n; k++) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = -inf;
                        next[i][j] = -1;
                    }
                }
            }
        }

        List<Integer> path = new LinkedList<>();
        // find the actual shortest path
        if (dp[s][e] == inf) {
            System.out.println("NO PATH EXISTS");
        }
        else {
            int at = s;
            for(; at != e; at = next[at][e]) {
                // negative cycle detected
                if (at == -1) {
                    return;
                }

                path.add(at);
            }
            // negative cycle detected
            if (next[at][e] == -1) {
                return;
            }
            path.add(e);

            System.out.println("SHORTEST PATH : " + path);
        }
    }

    public static void main(String[] args) {

        // value of infinity
        inf = 1000;

        // graph represented with an adjacency matrix
        graph = new int[][] {{0,3,inf,5},
                             {2,0,inf,4},
                             {inf,1,0,inf},
                             {inf,inf,2,0}};

        n = graph[0].length;

        // starting vertex
        int START = 2;
        // end vertex
        int END = 3;

        floyd_warshall(START,END);
    }
}