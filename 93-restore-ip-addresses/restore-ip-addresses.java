class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, "");
        return res;
    }

    void dfs(String s, int i, int parts, String cur) {
        if (parts == 4 && i == s.length()) {
            res.add(cur.substring(0, cur.length() - 1));
            return;
        }

        if (parts >= 4) return;

        for (int len = 1; len <= 3; len++) {
            if (i + len > s.length()) break;

            String sub = s.substring(i, i + len);
            if ((sub.length() > 1 && sub.charAt(0) == '0') || Integer.parseInt(sub) > 255)
                continue;

            dfs(s, i + len, parts + 1, cur + sub + ".");
        }
    }
}