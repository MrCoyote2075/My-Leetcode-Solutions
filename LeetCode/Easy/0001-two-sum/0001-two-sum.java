class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
            map.put(target - nums[i], i);

        for(int i = 0 ; i < nums.length ; i++) {
            Integer j = map.get(nums[i]);
            if(j != null && j != i)
                return new int[]{i,j};
        }

        return new int[]{};
    }
}