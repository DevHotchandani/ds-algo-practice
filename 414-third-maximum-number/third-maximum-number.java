class Solution {
    public int thirdMax(int[] nums) {
        Long a = null, b = null, c = null;

        for (int x : nums) {
            long v = x;

            if ((a != null && v == a) || 
                (b != null && v == b) || 
                (c != null && v == c)) continue;

            if (a == null || v > a) {
                c = b;
                b = a;
                a = v;
            } else if (b == null || v > b) {
                c = b;
                b = v;
            } else if (c == null || v > c) {
                c = v;
            }
        }

        return c == null ? a.intValue() : c.intValue();
    }
}