//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static class Point{
        int r,c;
        public Point(int row,int col){
            this.r=row;
            this.c=col;
        }
    }
    private static void bfs(char [][]grid,int row,int col){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        grid[row][col]='Z';

        while(!q.isEmpty()){
            Point p = q.remove();
            int r=p.r;
            int c=p.c;

            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];

                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]=='O'){
                    grid[nrow][ncol]='Z';
                    q.add(new Point(nrow,ncol));
                }
            }
        } 
    }
    static char[][] fill(int n, int m, char grid[][])
    {
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1)
                    if(grid[i][j]=='O') bfs(grid,i,j);
            }
        }

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='O') grid[i][j]='X';
                if(grid[i][j]=='Z') grid[i][j]='O';
            }
        }
        return grid;
    }
}