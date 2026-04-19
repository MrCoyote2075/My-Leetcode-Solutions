class Solution {
    public int candy(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = 0 ; i < n - 1 ; i++)
            if (nums[i] < nums[i + 1])
                ans[i + 1] = ans[i] + 1;
        
        int sum = 0;
        for (int i = n - 1 ; i > 0 ; i--) {
            if (nums[i - 1] > nums[i] && ans[i - 1] <= ans[i])
                ans[i - 1] = ans[i] + 1;
            
            sum += ans[i];
        }

        sum += ans[0];

        return sum;
    }
}