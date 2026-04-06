class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for (int x : nums) {
            int[] next = dp.clone();

            for (int i = 0; i < 3; i++) {
                int sum = dp[i] + x;
                next[sum % 3] = Math.max(next[sum % 3], sum);
            }

            dp = next;
        }

        return dp[0];
    }
}