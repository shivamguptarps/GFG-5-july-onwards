//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    static class Pair{
        int node, dist;
        public Pair(int n,int d){
            this.node=n;this.dist=d;
        }
    }
    
    public List<Integer> shortestPath(int V, int e, int edges[][]) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj[]= new ArrayList[V+1];
        
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<ArrayList<Integer>>();
        }
        
        // for(int i=0;i<adj.length;i++){
        //     for(int j=0;j<adj[i].size();j++){
        //         System.out.println(adj[i].get(j));
        //     }
        //     System.out.println();
        // }
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(wt);
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(u);
            temp1.add(wt);
            
            
            adj[u].add(temp);
            adj[v].add(temp1);
            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.dist-y.dist);
        
        int dist[]=new int[V+1];
        int par[]=new int[V+1];
        
        for(int i=0;i<par.length;i++) par[i]=i;
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        boolean vis[]=new boolean[V];
        
        pq.add(new Pair(1,0));
        
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int node=p.node;
            if(node==V) break;
            if(!vis[node]){
                vis[node]=true;
            
            for(int i=0;i<adj[node].size();i++){
                int u=node;
                int v=adj[node].get(i).get(0);
                int wt=adj[node].get(i).get(1);
                
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                    par[v]=u;
                }
            }
            }
        }
        int x=V;
        while(par[x]!=x){
            ans.add(x);
            x=par[x];
        }
        if(ans.isEmpty()){
            ans.add(-1);
            return ans;
        }
        ans.add(1);
        ans.add(dist[V]);
        
        
        // for(int i=0;i<adj.length;i++){
        //     for(int j=0;j<adj[i].size();j++){
        //         System.out.println(adj[i].get(j));
        //     }
        //     System.out.println();
        // }
        Collections.reverse(ans);
        return ans;
    }
}