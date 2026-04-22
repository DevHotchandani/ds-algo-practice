class Solution {
    public int maxDistance(int[] a, int[] b) {
        int ans = 0;

        for (int i = 0; i < a.length; i++) {
            int l = 0, r = b.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (a[i] <= b[mid]) {
                    ans = Math.max(ans, mid - i);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return ans;
    }
}