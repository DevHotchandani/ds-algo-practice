class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        dfs(arr, target, 0, new ArrayList<>(), res);
        return res;
    }

    void dfs(int[] arr, int target, int idx, List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            curr.add(arr[i]);
            dfs(arr, target - arr[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }
}