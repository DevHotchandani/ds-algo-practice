class Solution {
    public int countOperations(int a, int b) {
        int count = 0;

        while (a != 0 && b != 0) {
            if (a >= b) {
                count += a / b;
                a %= b;
            } else {
                count += b / a;
                b %= a;
            }
        }

        return count;
    }
}