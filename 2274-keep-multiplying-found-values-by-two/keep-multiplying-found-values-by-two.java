class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> st = new HashSet<>();

        for (int x : nums) st.add(x);

        while (st.contains(original)) {
            original *= 2;
        }

        return original;
    }
}