class Solution {
    public int maxPoints(int[][] pts) {
        int n = pts.length;
        if (n <= 2) return n;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> mp = new HashMap<>();
            int same = 1;

            for (int j = i + 1; j < n; j++) {
                int dx = pts[j][0] - pts[i][0];
                int dy = pts[j][1] - pts[i][1];

                if (dx == 0 && dy == 0) {
                    same++;
                    continue;
                }

                int g = gcd(dx, dy);
                dx /= g;
                dy /= g;

                String key = dx + "#" + dy;
                mp.put(key, mp.getOrDefault(key, 0) + 1);
            }

            int cur = 0;
            for (int v : mp.values()) {
                cur = Math.max(cur, v);
            }

            ans = Math.max(ans, cur + same);
        }

        return ans;
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}