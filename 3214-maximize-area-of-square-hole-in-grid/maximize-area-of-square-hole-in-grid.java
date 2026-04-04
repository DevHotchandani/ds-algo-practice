class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        int maxH = longest(h);
        int maxV = longest(v);

        int side = Math.min(maxH, maxV) + 1;
        return side * side;
    }

    int longest(int[] arr) {
        Arrays.sort(arr);

        int max = 1, cur = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }

        return max;
    }
}