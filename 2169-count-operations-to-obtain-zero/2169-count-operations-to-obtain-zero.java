class Solution {
    public int countOperations(int a, int b) {
        int cnt = 0;

        while (a != 0 && b != 0) {
            if (a >= b) a -= b;
            else b -= a;
            cnt++;
        }

        return cnt;
    }
}