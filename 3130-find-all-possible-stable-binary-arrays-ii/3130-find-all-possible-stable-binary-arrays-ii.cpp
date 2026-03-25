class Solution {
 public:
  int numberOfStableArrays(int a, int b, int lim) {
    constexpr int MOD = 1000000007;

    vector<vector<vector<long>>> dp(
        a + 1, vector<vector<long>>(b + 1, vector<long>(2)));

    for (int i = 0; i <= min(a, lim); ++i)
      dp[i][0][0] = 1;

    for (int j = 0; j <= min(b, lim); ++j)
      dp[0][j][1] = 1;

    for (int i = 1; i <= a; ++i)
      for (int j = 1; j <= b; ++j) {
        dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1] -
                       (i - lim < 1 ? 0 : dp[i - lim - 1][j][1]) + MOD) % MOD;

        dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1] -
                       (j - lim < 1 ? 0 : dp[i][j - lim - 1][0]) + MOD) % MOD;
      }

    return (dp[a][b][0] + dp[a][b][1]) % MOD;
  }
};