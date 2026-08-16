class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int cnt = 0;
        int[] vis = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                int[] com = new int[2];
                dfs(i, adj, vis, com);
                if(com[0]*(com[0]-1)==com[1]) cnt++;
            }
        }

        return cnt;
    }

    private void dfs(int v, List<List<Integer>> adj, int[] vis, int[] com){
        vis[v] = 1;
        com[0]++;
        com[1] += adj.get(v).size();

        for(Integer at : adj.get(v)){
            if(vis[at] == 0) dfs(at, adj, vis, com);
        }
    }
}