class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int cnt = 0;

        for (int i = bits.length - 2; i >= 0 && bits[i] == 1; i--) {
            cnt++;
        }

        return cnt % 2 == 0;
    }
}