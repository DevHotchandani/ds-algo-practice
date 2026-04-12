class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[][] dp = new int[27][27];

        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        dp[26][26] = 0;

        for (int i = 0; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int[][] next = new int[27][27];

            for (int x = 0; x < 27; x++) {
                for (int y = 0; y < 27; y++) {
                    next[x][y] = Integer.MAX_VALUE / 2;
                }
            }

            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {
                    int val = dp[f1][f2];
                    if (val >= Integer.MAX_VALUE / 2) continue;

                    int cost1 = val + (f1 == 26 ? 0 : dist(f1, cur));
                    next[cur][f2] = Math.min(next[cur][f2], cost1);

                    int cost2 = val + (f2 == 26 ? 0 : dist(f2, cur));
                    next[f1][cur] = Math.min(next[f1][cur], cost2);
                }
            }

            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 27; i++) {
            for (int j = 0; j < 27; j++) {
                ans = Math.min(ans, dp[i][j]);
            }
        }

        return ans;
    }

    int dist(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}