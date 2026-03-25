class Solution {
    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {
        backtrack("", n, k);
        return ans;
    }

    void backtrack(String curr, int n, int k) {
        if (curr.length() == n) {
            count++;
            if (count == k) ans = curr;
            return;
        }

        char[] ch = {'a', 'b', 'c'};

        for (int i = 0; i < 3; i++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch[i]) continue;

            backtrack(curr + ch[i], n, k);

            if (!ans.equals("")) return;
        }
    }
}