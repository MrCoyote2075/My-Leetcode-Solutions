class Solution {
    public ArrayList<ArrayList<int[]>> grp;
    public boolean[] vis;

    public boolean dij (int n, int src, int des, int k, int threshold) {
        int[] dist = new int[n];

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offer(src);
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;

        while (!dq.isEmpty()) {
            int u = dq.pollFirst();

            for (int[] ed : grp.get(u)) {
                int v = ed[0];
                int w = ed[1];

                if (threshold < w) {
                    if (dist[u] + 1 < dist[v]) {
                        dist[v] = dist[u] + 1;
                        dq.offer(v);
                    }
                } else {
                    if (dist[u] < dist[v]) {
                        dist[v] = dist[u];
                        dq.offer(v);
                    }
                }
            }
        }
        return dist[des] <= k ;
    }

    public boolean DFS(int u, int target, int k, int threshold) {

        if (k == -1)
            return false;

        if (u == target)
            return true;

        for (int[] ed : grp.get(u)) {
            int v = ed[0];
            int w = ed[1];

            if (!vis[v]) {
                vis[v] = true;
                if (DFS(v, target, threshold < w ? k - 1 : k, threshold)) {
                    vis[v] = false;
                    return true;
                }
                vis[v] = false;
            }
        }

        return false;
    }

    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        if (source == target)
            return 0;

        grp = new ArrayList<>();

        for (int i = 0; i < n; i++)
            grp.add(new ArrayList<>());

        int left = 0, right = (int) 1e9;
        for (int[] ed : edges) {
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];

            grp.get(u).add(new int[] { v, w });
            grp.get(v).add(new int[] { u, w });
        }
        
        vis = new boolean[n];
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (dij (n, source, target, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }

        return ans;
    }
}