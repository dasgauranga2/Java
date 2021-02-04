import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class shortest_path_floyd_warshall {

    static int[][] graph;
    static int inf;
    static int n;

    // FLOYD WARSHALL ALGORITHM
    // ALL-PAIRS SHORTEST PATH ALGORITHM
    // TIME COMPLEXITY : 0(V^3)
    public static void floyd_warshall() {
        
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

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
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

        floyd_warshall();
    }
}