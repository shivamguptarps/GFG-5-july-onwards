//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    private boolean dfs(ArrayList<ArrayList<Integer>>adj,int start,int []vis ){
        for(int it : adj.get(start)){
            if(vis[it]==0){
              vis[it] = vis[start]==1 ? 2 : 1;
                if(dfs(adj,it,vis)) return true;
            }
            else if(vis[it]==vis[start]) return true;
            else continue;
        }
        return false;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        
        int vis[] = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                vis[i]=1;
                if(dfs(adj,i,vis)) return false;
            }
        }

        return true;
    }
}