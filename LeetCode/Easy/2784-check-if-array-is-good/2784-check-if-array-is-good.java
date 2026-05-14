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