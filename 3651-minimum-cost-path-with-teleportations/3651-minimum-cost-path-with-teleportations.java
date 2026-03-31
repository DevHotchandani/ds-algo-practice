class Solution {
    public int minCost(int[][] mat, int k) {
        int r = mat.length, c = mat[0].length;
        int INF = Integer.MAX_VALUE / 2;

        int[][][] dp = new int[k + 1][r][c];

        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < r; i++) {
                Arrays.fill(dp[t][i], INF);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i > 0)
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i - 1][j] + mat[i][j]);
                if (j > 0)
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i][j - 1] + mat[i][j]);
            }
        }

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = mat[i][j];
                map.computeIfAbsent(val, x -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        List<Integer> vals = new ArrayList<>(map.keySet());
        vals.sort(Collections.reverseOrder());

        for (int t = 1; t <= k; t++) {
            int best = INF;

            for (int v : vals) {
                List<int[]> list = map.get(v);

                for (int[] p : list) {
                    best = Math.min(best, dp[t - 1][p[0]][p[1]]);
                }

                for (int[] p : list) {
                    dp[t][p[0]][p[1]] = best;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (i > 0)
                        dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i - 1][j] + mat[i][j]);
                    if (j > 0)
                        dp[t][i][j] = Math.min(dp[t][i][j], dp[t][i][j - 1] + mat[i][j]);
                }
            }
        }

        int res = INF;

        for (int t = 0; t <= k; t++) {
            res = Math.min(res, dp[t][r - 1][c - 1]);
        }

        return res;
    }
}