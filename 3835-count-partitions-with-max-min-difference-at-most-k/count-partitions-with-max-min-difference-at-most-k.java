import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        int mod = 1000000007;

        long[] dp = new long[n + 1];
        long[] pre = new long[n + 1];

        dp[0] = 1;
        pre[0] = 1;

        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < n; r++) {

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[r])
                maxQ.pollLast();
            maxQ.addLast(r);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[r])
                minQ.pollLast();
            minQ.addLast(r);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == l) maxQ.pollFirst();
                if (minQ.peekFirst() == l) minQ.pollFirst();
                l++;
            }

            dp[r + 1] = (pre[r] - (l > 0 ? pre[l - 1] : 0) + mod) % mod;
            pre[r + 1] = (pre[r] + dp[r + 1]) % mod;
        }

        return (int) dp[n];
    }
}