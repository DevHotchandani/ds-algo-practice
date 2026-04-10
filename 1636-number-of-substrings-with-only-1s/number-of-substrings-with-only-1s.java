class Solution {
    public int numSub(String s) {
        long ans = 0, cnt = 0;
        int mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                cnt++;
                ans += cnt;
            } else {
                cnt = 0;
            }
        }

        return (int)(ans % mod);
    }
}