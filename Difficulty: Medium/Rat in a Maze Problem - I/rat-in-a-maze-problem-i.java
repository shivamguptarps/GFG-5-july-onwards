//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
     private static void helper(int sr,int sc,String s,int vis[][],ArrayList<String> arl){
        if(sr<0 || sc<0) return;
        if(sr>=vis.length || sc>=vis.length) return;
        if(vis[sr][sc]==0) return;
        if(sr==vis.length-1 && sc==vis.length-1) {
            arl.add(s);
            return;
        }

        vis[sr][sc]=0;
        
        
        helper(sr, sc+1,s+"R",vis,arl);
        helper(sr+1, sc,s+"D",vis,arl);
        helper(sr, sc-1,s+"L",vis,arl);
        helper(sr-1, sc,s+"U",vis,arl);

        vis[sr][sc]=1;
    }
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> arl = new ArrayList<>();
        
        helper(0,0,"",mat,arl);
        return arl;
    }
}