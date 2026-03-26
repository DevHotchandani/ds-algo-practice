class Solution {

    int[] parent;

    public int[] processQueries(int c, int[][] edges, int[][] queries) {
        parent = new int[c + 1];
        for (int i = 1; i <= c; i++) parent[i] = i;

        for (int[] e : edges) union(e[0], e[1]);

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            int p = find(i);
            map.computeIfAbsent(p, k -> new TreeSet<>()).add(i);
        }

        boolean[] active = new boolean[c + 1];
        Arrays.fill(active, true);

        List<Integer> res = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = find(x);

            if (type == 1) {
                if (active[x]) {
                    res.add(x);
                } else {
                    TreeSet<Integer> set = map.get(root);
                    if (set.isEmpty()) res.add(-1);
                    else res.add(set.first());
                }
            } else {
                active[x] = false;
                map.get(root).remove(x);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
}