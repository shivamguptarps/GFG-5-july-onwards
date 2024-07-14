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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    private static int solveMem(int wt[],int val[],int W,int n,int dp[][]){
        if(n==0) return 0;

        if(dp[n][W]!=-1) return dp[n][W];

        if(wt[n-1]<=W){
            return dp[n][W] = Math.max(val[n-1]+solveMem(wt, val, W-wt[n-1], n,dp),solveMem(wt, val, W, n-1,dp));
        }
        else{
            return dp[n][W] = solveMem(wt, val, W, n-1,dp);
        }

    }
    
    static int knapSack(int n, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return (solveMem(wt, val, W, n, dp));
    }
}