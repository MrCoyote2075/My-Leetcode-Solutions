class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        boolean[] vis = new boolean[n];

        int max = 0; 
        for (int i = 0 ; i < n ; i++) {
            if (lights[i] != 0 && max <= lights[i])
                max = lights[i] + 1;
            
            if (0 < max) {
                max--;
                vis[i] = true;
            }
        }
        // System.out.println(Arrays.toString(vis));
        
        max = 0;
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (lights[i] != 0 && max <= lights[i])
                max = lights[i] + 1;
            
            if (0 < max) {
                max--;
                vis[i] = true;
            }
        }
        // System.out.println(Arrays.toString(vis));

        int ans = 0;
        int cnt = 0;
        for (int i = 0 ; i < n ; i++) {
            if (!vis[i]) 
                cnt++;

            else if (0 < cnt) {
                ans += (cnt / 3);

                if (cnt % 3 != 0)
                    ans++;
                
                cnt = 0;
            }
        }

        if (0 < cnt) {
            ans += (cnt / 3);

            if (cnt % 3 != 0)
                ans++;
        }

        // System.out.println(Arrays.toString(vis));

        return ans;
    }
} 

// 0 0 0 0 0