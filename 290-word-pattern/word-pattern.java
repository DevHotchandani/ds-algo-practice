class Solution {
    public boolean wordPattern(String p, String s) {
        String[] w = s.split(" ");
        if (p.length() != w.length) return false;

        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            String str = w[i];

            if (m1.containsKey(c)) {
                if (!m1.get(c).equals(str)) return false;
            } else {
                if (m2.containsKey(str)) return false;
                m1.put(c, str);
                m2.put(str, c);
            }
        }

        return true;
    }
}