class Solution {
    public int numRescueBoats(int[] arr, int x) {
        int n = arr.length;
        Arrays.sort(arr);

        int l = 0, r = n - 1;

        int ans = 0;
        while (l < r) {
            if (arr[l] + arr[r--] <= x)
                l++;

            ans++;
        }

        if (l == r)
            ans++;

        return ans;
    }
}