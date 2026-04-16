class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (int idx : queries) {
            List<Integer> list = map.get(nums[idx]);

            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);
            int sz = list.size();

            int left = list.get((pos - 1 + sz) % sz);
            int right = list.get((pos + 1) % sz);

            int d1 = Math.min(Math.abs(idx - left), n - Math.abs(idx - left));
            int d2 = Math.min(Math.abs(idx - right), n - Math.abs(idx - right));

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}