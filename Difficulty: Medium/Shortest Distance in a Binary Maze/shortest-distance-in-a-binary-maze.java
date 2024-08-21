//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class Pair{
        int dist;
        int r,c;
        public Pair(int r,int c,int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
        
    }

    int shortestPath(int[][] grid, int[] s, int[] dest) {
        
        if(grid[s[0]][s[1]]==0 || grid[dest[0]][dest[1]]==0) return -1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s[0],s[1],0));
        grid[s[0]][s[1]]=-1;
        
        int ans=-1;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            if(p.r==dest[0] && p.c==dest[1]) return p.dist;
            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
            
            for(int i=0;i<4;i++){
                int nrow=p.r+dr[i];
                int ncol=p.c+dc[i];
                
                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]==1){
                    if(nrow==dest[0] && ncol==dest[1]) return p.dist+1;
                    q.add(new Pair(nrow,ncol,p.dist+1));
                    grid[nrow][ncol]=-1;
                }
            }
        }
        return -1;
    }
}
