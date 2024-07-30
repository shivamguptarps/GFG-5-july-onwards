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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
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
    
    private void bfs(int grid[][],int row,int col,HashSet<String> hs){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(row,col));
        grid[row][col]=0;
        StringBuilder sb = new StringBuilder();
        sb.append(row-row);
        sb.append(col-col);
        sb.append(".");
        while(!q.isEmpty()){
            Point p=q.remove();
            int r=p.r;
            int c=p.c;
            
            int dr[]={-1,0,1,0};
            int dc[]={0,1,0,-1};
            
            for(int i=0;i<4;i++){
                    int nrow=r+dr[i];
                    int ncol=c+dc[i];
                    
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && grid[nrow][ncol]==1){
                        q.add(new Point(nrow,ncol));
                        grid[nrow][ncol]=0;
                        sb.append(nrow-row);
                        sb.append(ncol-col);
                        sb.append(".");
                    }
                
            }
        }
        hs.add(sb.toString());
    }
    public int countDistinctIslands(int[][] grid) {
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    bfs(grid,i,j,hs);
                }
            }
        }
        return hs.size();
    }
}