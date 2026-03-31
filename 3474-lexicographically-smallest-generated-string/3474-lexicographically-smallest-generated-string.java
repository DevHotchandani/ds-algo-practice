class Solution {
    public String generateString(String a, String b) {
        int n = a.length();
        int m = b.length();
        int len = n + m - 1;

        char[] res = new char[len];
        boolean[] free = new boolean[len];
        Arrays.fill(free, true);

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int idx = i + j;
                    if (res[idx] != 0 && res[idx] != b.charAt(j)) return "";
                    res[idx] = b.charAt(j);
                    free[idx] = false;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (res[i] == 0) res[i] = 'a';
        }

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) == 'F' && check(res, i, b)) {
                int pos = find(i, m, free);
                if (pos == -1) return "";
                res[pos] = 'b';
                free[pos] = false;
            }
        }

        return new String(res);
    }

    private boolean check(char[] arr, int start, String t) {
        for (int j = 0; j < t.length(); j++) {
            if (arr[start + j] != t.charAt(j)) return false;
        }
        return true;
    }

    private int find(int start, int m, boolean[] free) {
        int idx = -1;
        for (int j = 0; j < m; j++) {
            int pos = start + j;
            if (free[pos]) idx = pos;
        }
        return idx;
    }
}