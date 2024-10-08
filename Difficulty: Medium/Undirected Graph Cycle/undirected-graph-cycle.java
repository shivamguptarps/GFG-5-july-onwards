//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    
    private boolean bfs(ArrayList<ArrayList<Integer>> adj,int start,int vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=-2;
        while(!q.isEmpty()){
            // System.out.println(Arrays.toString(vis));
            int temp=q.remove();
            
            for(int it : adj.get(temp)){
                if(vis[it]==-1){
                    vis[it]=temp;
                    q.add(it);
                }
                // check whether my neighbour means it mera parent to nahi hai means jis it ke liye check kar rahe hain wo temp ka parent to nahi hai
                else if(it!=vis[temp]) return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Arrays.fill(vis,-1);
        for(int i=0;i<V;i++){
            if(vis[i]==-1)
                if(bfs(adj,i,vis)) return true;
            
        }
        return false;
    }
}