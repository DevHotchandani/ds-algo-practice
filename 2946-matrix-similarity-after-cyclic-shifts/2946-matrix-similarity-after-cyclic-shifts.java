class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        int[][] curr = new int[m][n];
        for (int i = 0; i < m; i++)
            curr[i] = mat[i].clone();

        for (int step = 0; step < k; step++) {
            int[][] next = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i % 2 == 0) {
                        next[i][j] = curr[i][(j + 1) % n];
                    } else {
                        next[i][j] = curr[i][(j - 1 + n) % n];
                    }
                }
            }

            curr = next;
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (curr[i][j] != mat[i][j]) return false;

        return true;
    }
}