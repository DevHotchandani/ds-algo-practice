class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] pref = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int top = (i > 0) ? pref[i - 1][j] : 0;
                int left = (j > 0) ? pref[i][j - 1] : 0;
                int diag = (i > 0 && j > 0) ? pref[i - 1][j - 1] : 0;

                pref[i][j] = grid[i][j] + top + left - diag;
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pref[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
    }
}