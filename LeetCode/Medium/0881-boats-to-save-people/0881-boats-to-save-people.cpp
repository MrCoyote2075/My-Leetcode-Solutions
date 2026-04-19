class Solution {
public:
    int numRescueBoats(vector<int>& arr, int x) {
        int n = arr.size();
        sort(arr.begin(), arr.end());

        int ans = 0;
        int l = 0, r = n - 1;

        while (l < r) {
            if (arr[l] + arr[r] <= x) {
                l++;
                r--;
            } else
                r--;

            ans++;
        }

        if (l == r)
            ans++;

        return ans;
    }
};