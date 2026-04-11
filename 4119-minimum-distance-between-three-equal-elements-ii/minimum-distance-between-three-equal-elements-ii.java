class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mp.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int res = Integer.MAX_VALUE;

        for (List<Integer> list : mp.values()) {
            if (list.size() < 3) continue;

            for (int i = 0; i + 2 < list.size(); i++) {
                int d = 2 * (list.get(i + 2) - list.get(i));
                res = Math.min(res, d);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}