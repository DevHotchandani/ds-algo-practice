class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 2; j < n; j++) {
                if (isArithmetic(nums, i, j)) ans++;
            }
        }

        return ans;
    }

    boolean isArithmetic(int[] a, int l, int r) {
        int d = a[l + 1] - a[l];
        for (int i = l + 2; i <= r; i++) {
            if (a[i] - a[i - 1] != d) return false;
        }
        return true;
    }
}