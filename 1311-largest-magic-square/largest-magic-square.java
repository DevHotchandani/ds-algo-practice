class Solution {
    public int largestMagicSquare(int[][] g) {
        int m = g.length, n = g[0].length;
        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; i + k <= m && j + k <= n; k++) {
                    if (check(g, i, j, k)) {
                        ans = Math.max(ans, k);
                    }
                }
            }
        }

        return ans;
    }

    boolean check(int[][] g, int r, int c, int k) {
        int sum = 0;

        for (int j = c; j < c + k; j++) sum += g[r][j];

        for (int i = r; i < r + k; i++) {
            int s = 0;
            for (int j = c; j < c + k; j++) s += g[i][j];
            if (s != sum) return false;
        }

        for (int j = c; j < c + k; j++) {
            int s = 0;
            for (int i = r; i < r + k; i++) s += g[i][j];
            if (s != sum) return false;
        }

        int d1 = 0, d2 = 0;
        for (int i = 0; i < k; i++) {
            d1 += g[r + i][c + i];
            d2 += g[r + i][c + k - 1 - i];
        }

        return d1 == sum && d2 == sum;
    }
}