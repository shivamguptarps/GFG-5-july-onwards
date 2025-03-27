//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    void bfs(ArrayList<ArrayList<Integer>> adj ,boolean vis[],int s,ArrayList<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        // System.out.println(q);
        while(!q.isEmpty()){
            int p = q.remove();
            if(!vis[p]){

                ans.add(p);
                        // System.out.println(ans);
                
                vis[p]=true;
                for(int it : adj.get(p)){
                    q.add(it);
                }
            }
        }
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean vis[]=new boolean[V];
        // for(int i=0;i<V;i++){
        //     if(!vis[i]){
                bfs(adj,vis,0,ans);
        //     }
        // }
        //         System.out.println(ans);
        // bfs

        return ans;
    }
}