//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static int solve(int arr[],int k,int n,int dp[]){
        if(n==0 || n==1) return 0;
            
            if(dp[n]!=-1) return dp[n];
        
        int ans=Integer.MAX_VALUE;
        int temp=0;
        for(int i=1;i<=k;i++){
            if(n-1-i>=0){
                temp=Math.abs(arr[n-1]-arr[n-1-i])+solve(arr,k,n-i,dp);
            }
            else break;
            ans=Math.min(temp,ans);
        }
        return dp[n]=ans;
    }
    public int minimizeCost(int arr[], int N, int K) {
        int dp[]= new int[N+1];
        Arrays.fill(dp,-1);
        return solve(arr,K,N,dp);
    }
}
