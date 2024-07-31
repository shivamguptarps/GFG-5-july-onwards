//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,int start,boolean vis[],boolean st[]){
        vis[start]=true;
        st[start]=true;
        
        for(int it : adj.get(start)){
            if(st[it]) return true;
            else if(!vis[it]){
                boolean cc=dfs(adj,it,vis,st);
                if(cc) return true;
            }
        }
        st[start]=false;
        return false;
    }
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        boolean st[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i])
                if(dfs(adj,i,vis,new boolean[V])) return true;
            
        }
        return false;
    }
}