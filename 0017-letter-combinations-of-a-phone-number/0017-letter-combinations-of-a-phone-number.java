class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        solve(digits, 0, new StringBuilder());
        return ans;
    }

    void solve(String d, int idx, StringBuilder sb) {
        if (idx == d.length()) {
            ans.add(sb.toString());
            return;
        }

        String s = map[d.charAt(idx) - '0'];

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            solve(d, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}