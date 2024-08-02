//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int V, int m, ArrayList<ArrayList<Integer>> given) 
    {
        ArrayList<Integer> adj[] = new ArrayList[V];
        for(int i=0;i<V;i++) adj[i]=new ArrayList<>();

        for(int i=0;i<given.size();i++){
                adj[given.get(i).get(1)].add(given.get(i).get(0));
        }

        // int count =0;
        

        int ind[]=new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj[i]){
                ind[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0) q.add(i);
        }

        int ans[]=new int[V];
        int i=0;

        while(!q.isEmpty()){
            int temp=q.remove();
            // count++;
            ans[i++]=temp;
            for(int it : adj[temp]){
                ind[it]--;
                if(ind[it]==0) q.add(it);
            }
        }
        if(i==V) return ans;
        return new int[0];
    }
}