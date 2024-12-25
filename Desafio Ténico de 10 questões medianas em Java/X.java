// Questão 10: Implemente um algoritmo para resolver o problema do caixeiro viajante usando programação dinâmica.
public class TravelingSalesmanProblem {
    private static final int INF = Integer.MAX_VALUE;

    public int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][1] = 0;

        for (int mask = 1; mask < (1 << n); mask += 2) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) != 0) {
                    for (int v = 0; v < n; v++) {
                        if ((mask & (1 << v)) == 0) {
                            dp[v][mask | (1 << v)] = Math.min(dp[v][mask | (1 << v)], dp[u][mask] + graph[u][v]);
                        }
                    }
                }
            }
        }

        int res = INF;
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[i][(1 << n) - 1] + graph[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        TravelingSalesmanProblem tsp = new TravelingSalesmanProblem();
        System.out.println("O custo mínimo do caminho é: " + tsp.tsp(graph));
    }
}

    