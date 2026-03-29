class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder(s);
            for (int j = 0; j < s.length(); j++) {
                sb.setCharAt(j, s.charAt(j) == '0' ? '1' : '0');
            }
            s = s + "1" + sb.reverse().toString();
        }

        return s.charAt(k - 1);
    }
}