class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();

        for (int[] o : obstacles) {
            long key = ((long)o[0] << 32) | (o[1] & 0xffffffffL);
            set.add(key);
        }

        int x = 0, y = 0;
        int dir = 0;
        int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};

        int max = 0;

        for (int c : commands) {
            if (c == -1) dir = (dir + 1) % 4;
            else if (c == -2) dir = (dir + 3) % 4;
            else {
                for (int i = 0; i < c; i++) {
                    int nx = x + d[dir][0];
                    int ny = y + d[dir][1];

                    long key = ((long)nx << 32) | (ny & 0xffffffffL);

                    if (set.contains(key)) break;

                    x = nx;
                    y = ny;

                    max = Math.max(max, x * x + y * y);
                }
            }
        }

        return max;
    }
}