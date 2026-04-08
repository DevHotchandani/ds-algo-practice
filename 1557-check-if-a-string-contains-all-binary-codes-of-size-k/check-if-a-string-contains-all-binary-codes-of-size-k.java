class Solution {
    public boolean hasAllCodes(String str, int len) {
        int size = str.length();
        int total = 1 << len;

        if (size - len + 1 < total) return false;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i <= size - len; i++) {
            seen.add(str.substring(i, i + len));
        }

        return seen.size() == total;
    }
}