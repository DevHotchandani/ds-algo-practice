class Solution {
    public int minOperations(int[] a) {
        int n = a.length;
        int ones = 0;

        for (int x : a) {
            if (x == 1) ones++;
        }

        if (ones > 0) return n - ones;

        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = a[i];
            for (int j = i; j < n; j++) {
                g = gcd(g, a[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1;

        return (minLen - 1) + (n - 1);
    }

    int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}