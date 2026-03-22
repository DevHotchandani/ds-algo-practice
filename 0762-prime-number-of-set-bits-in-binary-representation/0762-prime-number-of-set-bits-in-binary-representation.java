class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) {
            int bits = Integer.bitCount(i);
            if (isPrime(bits)) ans++;
        }

        return ans;
    }

    boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}