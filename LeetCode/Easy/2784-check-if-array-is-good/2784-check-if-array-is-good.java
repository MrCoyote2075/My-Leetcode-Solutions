class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        
        int i = 0;
        for (int num : nums) 
            if (num != ++i)
                break;
        
        int n = nums.length;
        return (i == n && nums[n-1] == n-1);
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