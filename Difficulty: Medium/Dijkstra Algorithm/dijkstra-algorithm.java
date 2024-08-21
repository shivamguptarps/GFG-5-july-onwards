//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution
{
    static class Pair{
        int node, dist;
        public Pair(int n,int d){
            this.node=n;this.dist=d;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int src)
    {
        Queue<Pair> pq = new LinkedList<>();
        
        int dist[]=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        
        pq.add(new Pair(src,0));
        
        while(!pq.isEmpty()){
            // for(Pair it : pq) System.out.print(it.node+" ");
            // System.out.println();
            Pair p=pq.remove();
            int node=p.node;
            
            for(int i=0;i<adj.get(node).size();i++){
                int u=node;
                int v=adj.get(node).get(i).get(0);
                int wt=adj.get(node).get(i).get(1);
                
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            
            }
        }
        return dist;
    }
}

