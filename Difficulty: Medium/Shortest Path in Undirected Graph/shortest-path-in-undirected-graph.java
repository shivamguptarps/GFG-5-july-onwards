class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        int ans[]=new int[adj.size()];
        for(int i=0;i<ans.length;i++) ans[i]=-1;
        ans[src]=0;
        visited[src] = true;
        queue.add(src);
        int temp=0;

        while (!queue.isEmpty()) {
            
            temp++;
            int size=queue.size();
            for(int i=0;i<size;i++){
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    ans[neighbor]=temp;
                }
            }
            }
        }
    
    return ans;
        
    }
}
