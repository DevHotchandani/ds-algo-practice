class Solution {
    public int minimumDeletions(String s) {
        int b = 0, dp = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                b++;
            } else {
                dp = Math.min(dp + 1, b);
            }
        }

        return dp;
    }
}