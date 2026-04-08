class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c != (i % 2 == 0 ? '0' : '1')) diff1++;
            if (c != (i % 2 == 0 ? '1' : '0')) diff2++;
        }

        return Math.min(diff1, diff2);
    }
}