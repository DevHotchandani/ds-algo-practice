/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    List<TreeNode> solve(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();

        if (l > r) {
            ans.add(null);
            return ans;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = solve(l, i - 1);
            List<TreeNode> right = solve(i + 1, r);

            for (TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = a;
                    root.right = b;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}