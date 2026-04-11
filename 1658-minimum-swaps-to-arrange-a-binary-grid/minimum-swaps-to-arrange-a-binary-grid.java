class Solution {
    public int minSwaps(int[][] g) {
        int n = g.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean ok = false;

            for (int j = i; j < n; j++) {
                if (isValidRow(g[j], i)) {
                    ok = true;

                    for (int k = j; k > i; k--) {
                        int[] temp = g[k];
                        g[k] = g[k - 1];
                        g[k - 1] = temp;
                        ans++;
                    }
                    break;
                }
            }

            if (!ok) return -1;
        }

        return ans;
    }

    boolean isValidRow(int[] row, int idx) {
        for (int i = idx + 1; i < row.length; i++) {
            if (row[i] == 1) return false;
        }
        return true;
    }
}