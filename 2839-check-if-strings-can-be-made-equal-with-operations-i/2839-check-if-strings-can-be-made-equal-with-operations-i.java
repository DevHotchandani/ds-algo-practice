class Solution {
    public boolean canBeEqual(String s1, String s2) {

        char[] a = {s1.charAt(0), s1.charAt(2)};
        char[] b = {s2.charAt(0), s2.charAt(2)};

        char[] c = {s1.charAt(1), s1.charAt(3)};
        char[] d = {s2.charAt(1), s2.charAt(3)};

        java.util.Arrays.sort(a);
        java.util.Arrays.sort(b);
        java.util.Arrays.sort(c);
        java.util.Arrays.sort(d);

        return java.util.Arrays.equals(a, b) &&
               java.util.Arrays.equals(c, d);
    }
}