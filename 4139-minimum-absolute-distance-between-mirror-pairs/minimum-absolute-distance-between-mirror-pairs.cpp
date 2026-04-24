class Solution {
public:
    int reverseNum(int n) {
        int rev = 0;
        while(n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }

    int minMirrorPairDistance(vector<int>& nums) {
        unordered_map<int, int> mp;
        int ans = INT_MAX;

        for(int i = 0; i < nums.size(); i++) {

            if(mp.count(nums[i])) {
                ans = min(ans, i - mp[nums[i]]);
            }

            int rev = reverseNum(nums[i]);
            mp[rev] = i;
        }

        return (ans == INT_MAX) ? -1 : ans;
    }
};