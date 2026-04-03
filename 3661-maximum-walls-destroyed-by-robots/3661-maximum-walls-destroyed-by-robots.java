class Solution {
    private Integer[][] dp;
    private int[][] robotsData;
    private int[] wallPositions;
    private int size;

    public int maxWalls(int[] robotPos, int[] range, int[] walls) {
        size = robotPos.length;

        robotsData = new int[size][2];
        for (int i = 0; i < size; i++) {
            robotsData[i][0] = robotPos[i];
            robotsData[i][1] = range[i];
        }

        Arrays.sort(robotsData, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);

        wallPositions = walls;
        dp = new Integer[size][2];

        return solve(size - 1, 1);
    }

    private int solve(int idx, int state) {
        if (idx < 0) return 0;

        if (dp[idx][state] != null) return dp[idx][state];

        int pos = robotsData[idx][0];
        int dist = robotsData[idx][1];

        int leftLimit = pos - dist;
        if (idx > 0) {
            leftLimit = Math.max(leftLimit, robotsData[idx - 1][0] + 1);
        }

        int leftStart = findIndex(wallPositions, leftLimit);
        int leftEnd = findIndex(wallPositions, pos + 1);

        int takeLeft = solve(idx - 1, 0) + (leftEnd - leftStart);

        int rightLimit = pos + dist;
        if (idx + 1 < size) {
            if (state == 0) {
                rightLimit = Math.min(rightLimit, robotsData[idx + 1][0] - robotsData[idx + 1][1] - 1);
            } else {
                rightLimit = Math.min(rightLimit, robotsData[idx + 1][0] - 1);
            }
        }

        int rightStart = findIndex(wallPositions, pos);
        int rightEnd = findIndex(wallPositions, rightLimit + 1);

        int takeRight = solve(idx - 1, 1) + (rightEnd - rightStart);

        return dp[idx][state] = Math.max(takeLeft, takeRight);
    }

    private int findIndex(int[] arr, int key) {
        int res = Arrays.binarySearch(arr, key);
        return res < 0 ? -res - 1 : res;
    }
}