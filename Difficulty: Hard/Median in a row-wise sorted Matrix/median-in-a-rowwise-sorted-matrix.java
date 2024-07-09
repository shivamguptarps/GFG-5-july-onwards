//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private int findSmaller(int m[][],int ele){
        int ans=0;
        for(int i=0;i<m.length;i++){
            int low=0,high=m[0].length-1;
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if(m[i][mid]<=ele) low=mid+1;
                else high=mid-1;
            }
            ans+=low;
        }
        return ans;
    }
    
    int median(int mat[][], int R, int C) {
        int n=R*C;
        
        int low=1,high=2000;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            int smaller = findSmaller(mat,mid);
            
            if(smaller>n/2) high=mid-1;
            else low=mid+1;
            
        }
        return low;
    }
}