class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];

        for (int num : nums) {
            if (num >= n)
                return false;

            if (vis[num])
                if (num == n - 1)
                    vis[0] = true;
                else
                    return false;
            
            vis[num] = true;
        }

        for (boolean val : vis) 
            if (!val) return false;

        return true;
    }
}
// int n = nums.length - 1;
// int ans = (n * (n + 1)) / 2;
// ans += n;

// int sum = 0;
// for (int num : nums)
//     sum += num;

// System.out.println(sum);
// return ans == sum;