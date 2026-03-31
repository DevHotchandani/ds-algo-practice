class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isMagic(grid, i, j)) ans++;
            }
        }

        return ans;
    }

    boolean isMagic(int[][] g, int r, int c) {
        if (g[r+1][c+1] != 5) return false;

        boolean[] seen = new boolean[10];

        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) return false;
                seen[v] = true;
            }
        }

        int s = g[r][c] + g[r][c+1] + g[r][c+2];

        if (g[r+1][c] + g[r+1][c+1] + g[r+1][c+2] != s) return false;
        if (g[r+2][c] + g[r+2][c+1] + g[r+2][c+2] != s) return false;

        if (g[r][c] + g[r+1][c] + g[r+2][c] != s) return false;
        if (g[r][c+1] + g[r+1][c+1] + g[r+2][c+1] != s) return false;
        if (g[r][c+2] + g[r+1][c+2] + g[r+2][c+2] != s) return false;

        if (g[r][c] + g[r+1][c+1] + g[r+2][c+2] != s) return false;
        if (g[r][c+2] + g[r+1][c+1] + g[r+2][c] != s) return false;

        return true;
    }
}