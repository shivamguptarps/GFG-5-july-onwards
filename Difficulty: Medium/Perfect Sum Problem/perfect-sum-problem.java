//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
    

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    final int mod=1000000007;
	    
	    int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    dp[i][j] =0;
                if (j == 0 && i==0)
                    dp[i][j] =1;
                else if(j==0 &&  i<n+1){
                    if(arr[i-1]==0) dp[i][j]=dp[i-1][j]+1;
                    else dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        
        
        

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]]%mod + dp[i - 1][j]%mod)%mod;
                } else {
                    dp[i][j] = dp[i - 1][j]%mod;
                }
            }
        }
        return dp[n][sum];
        
        // return solve(n,arr,sum);
        
	} 
}