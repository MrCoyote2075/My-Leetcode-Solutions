class Solution {
public:
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> memo(n + 1);

        for (int i = n - 1 ; i >= 0 ; i--) {
            int ans = 0;

            int maxx = 0;
            for (int j = i ; j < n && j < i + k ; j++) {
                maxx = max(maxx, arr[j]);

                ans = max(ans, memo[j + 1] + (maxx * (j - i + 1)));
            }

            memo[i] = ans;
        }

        return memo[0];
    }
};

/*
        if (i == n)
            return 0;
        
        if (memo[i] != -1)
            return memo[i];
        
        int ans = 0; 

        int max = 0;
        for (int j = i ; j < arr.length & j < i + k; j++) {
            max = Math.max(max, arr[j]);

            ans = Math.max(ans, rec (j + 1) + (max * (j - i + 1)));
        }
        
        return memo[i] = ans;

*/