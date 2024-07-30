//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Point{
        int r,c;
        public Point(int row,int col){
            this.r=row;
            this.c=col;
        }
    }
    private void bfs(int [][]grid,int row,int col){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        grid[row][col]=0;

        while(!q.isEmpty()){
            Point p = q.remove();
            int r=p.r;
            int c=p.c;

            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1){
                    grid[nrow][ncol]=0;
                    q.add(new Point(nrow,ncol));
                }
            }
        } 
    }
    public int numberOfEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1)
                    if(grid[i][j]==1) bfs(grid,i,j);
            }
        }
        int cnt = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(grid[i][j] == 1) 
                    cnt++; 
            }
        }
        return cnt; 


    }
}