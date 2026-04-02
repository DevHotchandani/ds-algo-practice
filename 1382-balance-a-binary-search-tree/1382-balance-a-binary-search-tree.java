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
import java.util.*;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return build(list, 0, list.size() - 1);
    }

    void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    TreeNode build(List<Integer> list, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = build(list, l, mid - 1);
        node.right = build(list, mid + 1, r);

        return node;
    }
}