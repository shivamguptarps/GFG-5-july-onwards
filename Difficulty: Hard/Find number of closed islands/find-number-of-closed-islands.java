//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
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
    public int closedIslands(int[][] grid, int N, int M){
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1)
                    if(grid[i][j]==1) bfs(grid,i,j);
            }
        }
        int ans=0;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    bfs(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
}