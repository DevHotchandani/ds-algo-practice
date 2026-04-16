class Solution {
    public long minimumCost(String s, String t, String[] o, String[] c, int[] cost) {
        int n = s.length();
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;

        for (String x : o) if (!id.containsKey(x)) id.put(x, idx++);
        for (String x : c) if (!id.containsKey(x)) id.put(x, idx++);

        long[][] dist = new long[idx][idx];
        for (int i = 0; i < idx; i++) Arrays.fill(dist[i], Long.MAX_VALUE / 2);
        for (int i = 0; i < idx; i++) dist[i][i] = 0;

        for (int i = 0; i < o.length; i++) {
            int u = id.get(o[i]);
            int v = id.get(c[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < idx; k++) {
            for (int i = 0; i < idx; i++) {
                for (int j = 0; j < idx; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        Map<String, Map<String, Long>> conv = new HashMap<>();
        for (String a : id.keySet()) {
            for (String b : id.keySet()) {
                int u = id.get(a), v = id.get(b);
                if (dist[u][v] < Long.MAX_VALUE / 2 && a.length() == b.length()) {
                    conv.computeIfAbsent(a, k -> new HashMap<>()).put(b, dist[u][v]);
                }
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] >= Long.MAX_VALUE / 2) continue;

            if (s.charAt(i) == t.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            for (String x : conv.keySet()) {
                int len = x.length();
                if (i + len <= n && s.substring(i, i + len).equals(x)) {
                    for (String y : conv.get(x).keySet()) {
                        if (t.substring(i, i + len).equals(y)) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + conv.get(x).get(y));
                        }
                    }
                }
            }
        }

        return dp[n] >= Long.MAX_VALUE / 2 ? -1 : dp[n];
    }
}