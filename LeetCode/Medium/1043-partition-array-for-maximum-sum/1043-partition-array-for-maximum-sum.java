class Solution {
    public int n;
    public int k;
    public int[] arr;
    public int[] memo;

    public int rec (int i) {
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
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        this.k = k;
        this.arr = arr;

        memo = new int[n];
        Arrays.fill(memo, -1);

        return rec(0);
    }
}