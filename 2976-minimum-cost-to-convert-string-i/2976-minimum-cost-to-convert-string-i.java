class Solution {
    public long minimumCost(String s, String t, char[] o, char[] c, int[] cost) {
        long[][] dist = new long[26][26];
        long INF = (long)1e15;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        for (int i = 0; i < o.length; i++) {
            int u = o[i] - 'a';
            int v = c[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            int v = t.charAt(i) - 'a';

            if (dist[u][v] == INF) return -1;
            ans += dist[u][v];
        }

        return ans;
    }
}