class TreeAncestor {

    int[][] up;
    int LOG;

    public TreeAncestor(int n, int[] parent) {
        LOG = 17;
        up = new int[n][LOG];

        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i];
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (up[i][j - 1] == -1) up[i][j] = -1;
                else up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < LOG; j++) {
            if ((k & (1 << j)) != 0) {
                node = node == -1 ? -1 : up[node][j];
            }
        }
        return node;
    }
}