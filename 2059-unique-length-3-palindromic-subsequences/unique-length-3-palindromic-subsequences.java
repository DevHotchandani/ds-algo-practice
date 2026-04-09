class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);

            if (left == -1 || right - left < 2) continue;

            boolean[] vis = new boolean[26];

            for (int i = left + 1; i < right; i++) {
                vis[s.charAt(i) - 'a'] = true;
            }

            for (int i = 0; i < 26; i++) {
                if (vis[i]) ans++;
            }
        }

        return ans;
    }
}