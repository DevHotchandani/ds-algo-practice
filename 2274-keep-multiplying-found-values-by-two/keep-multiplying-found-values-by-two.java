class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean found = true;

        while (found) {
            found = false;
            for (int x : nums) {
                if (x == original) {
                    original *= 2;
                    found = true;
                    break;
                }
            }
        }

        return original;
    }
}