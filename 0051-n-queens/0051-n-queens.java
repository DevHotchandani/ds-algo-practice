class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] anti = new boolean[2 * n];

        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        dfs(0, n, board, res, col, diag, anti);
        return res;
    }

    void dfs(int r, int n, char[][] board, List<List<String>> res,
             boolean[] col, boolean[] diag, boolean[] anti) {

        if (r == n) {
            List<String> temp = new ArrayList<>();
            for (char[] row : board) temp.add(new String(row));
            res.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d = r - c + n;
            int a = r + c;

            if (col[c] || diag[d] || anti[a]) continue;

            board[r][c] = 'Q';
            col[c] = diag[d] = anti[a] = true;

            dfs(r + 1, n, board, res, col, diag, anti);

            board[r][c] = '.';
            col[c] = diag[d] = anti[a] = false;
        }
    }
}