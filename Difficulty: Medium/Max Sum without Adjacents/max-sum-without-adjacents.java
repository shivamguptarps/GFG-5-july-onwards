//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int solve(int nums[],int n,int dp[]){
        if(n<=0) return 0;
        if(dp[n]!=-1) return dp[n];
        return dp[n]= Math.max(nums[n-1]+solve(nums,n-2,dp),solve(nums,n-1,dp));
    }
    
    int findMaxSum(int nums[], int n) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,nums.length,dp);
    }
}