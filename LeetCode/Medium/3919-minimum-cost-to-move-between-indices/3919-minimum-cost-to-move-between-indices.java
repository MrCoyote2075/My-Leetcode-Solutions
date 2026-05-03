class Solution {
    public int[] compute(int[] nums, int start, int end) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        int od = 0 < end - start ? 1 : -1;

        int val = 0;
        if (start == 0 || start == n - 1) {
            val = 1;
            prefix[0 < od ? 1 : n - 1] = 1;
            start += od;
        }

        for (int i = start; 0 < od ? i < end : end < i; i += od) {
            int ind1 = i + od;
            int ind2 = i - od;

            int diff1 = Math.abs(nums[i] - nums[ind1]);
            int diff2 = Math.abs(nums[i] - nums[ind2]);

            if (diff1 == diff2 && od < 0)
                val++;
            else {
                if (0 < od)
                    val += diff1 < diff2 ? 1 : diff1;
                else
                    val += diff1 < diff2 ? 1 : diff1;
            }

            prefix[0 < od ? i + 1 : i] = val;
        }

        return prefix;
    }

    public int[] minCost(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int k = 0;
        int n = nums.length;

        int[] prefix = compute(nums, 0, n - 1);
        int[] suffix = compute(nums, n - 1, 0);

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(suffix));

        for (int[] qu : queries) {
            int start = qu[0];
            int end = qu[1];
            
            if (start == end)
                k++;

            else if (start <= end)
                ans[k++] = prefix[end] - prefix[start];
            
            else 
                ans[k++] = suffix[end + 1] - suffix[start + 1];

        }

        return ans;
    }
}