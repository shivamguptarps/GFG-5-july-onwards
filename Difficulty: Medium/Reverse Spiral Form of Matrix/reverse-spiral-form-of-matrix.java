//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] matrix)
    {
        int ans[]=new int[R*C];
        int idx=R*C-1;
        
        int sRow=0,sCol=0,eRow=R-1,eCol=C-1;

        while(sRow<=eRow && sCol<=eCol){
            for(int i=sCol;i<=eCol;i++){
                ans[idx--]=matrix[sRow][i];
            }
            for(int i=sRow+1;i<=eRow;i++){
                ans[idx--]=(matrix[i][eCol]);
            }

            for(int i=eCol-1;i>=sCol;i--){
                if(sRow==eRow) return ans;
                ans[idx--]=(matrix[eRow][i]);
            }
            for(int i=eRow-1;i>=sRow+1;i--){
                if(sCol==eCol) return ans;
                ans[idx--]=(matrix[i][sCol]);
            }
            sRow++;sCol++;eRow--;eCol--;
        }
        return ans;
    }
}