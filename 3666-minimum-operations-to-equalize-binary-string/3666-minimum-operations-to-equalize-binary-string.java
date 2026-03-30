class Solution {
    public int minOperations(String str, int k) {
        int len = str.length();

        TreeSet<Integer>[] sets = new TreeSet[2];
        Arrays.setAll(sets, i -> new TreeSet<>());

        for (int i = 0; i <= len; i++) {
            sets[i % 2].add(i);
        }

        int zeroCount = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') zeroCount++;
        }

        sets[zeroCount % 2].remove(zeroCount);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(zeroCount);

        int steps = 0;

        while (!dq.isEmpty()) {
            for (int sz = dq.size(); sz > 0; sz--) {
                int curr = dq.poll();

                if (curr == 0) return steps;

                int left = curr + k - 2 * Math.min(curr, k);
                int right = curr + k - 2 * Math.max(k - len + curr, 0);

                TreeSet<Integer> set = sets[left % 2];

                Integer nxt = set.ceiling(left);
                while (nxt != null && nxt <= right) {
                    dq.offer(nxt);
                    set.remove(nxt);
                    nxt = set.ceiling(left);
                }
            }
            steps++;
        }

        return -1;
    }
}