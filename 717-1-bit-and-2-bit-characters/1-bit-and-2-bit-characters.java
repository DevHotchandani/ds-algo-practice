class Solution {
    public boolean isOneBitCharacter(int[] b) {
        int i = 0;
        int n = b.length;

        while (i < n - 1) {
            if (b[i] == 0) i++;
            else i += 2;
        }

        return i == n - 1;
    }
}