class Solution {
    static class Node {
        Node[] child = new Node[2];
    }

    public int findMaximumXOR(int[] nums) {
        Node root = new Node();

        for (int num : nums) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.child[bit] == null) {
                    node.child[bit] = new Node();
                }
                node = node.child[bit];
            }
        }

        int max = 0;

        for (int num : nums) {
            Node node = root;
            int curr = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int opposite = 1 - bit;

                if (node.child[opposite] != null) {
                    curr |= (1 << i);
                    node = node.child[opposite];
                } else {
                    node = node.child[bit];
                }
            }

            max = Math.max(max, curr);
        }

        return max;
    }
}