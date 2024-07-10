//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
     static boolean solveMem(int n,int arr[],int sum,int dp[][]){
        // if(n==0 && sum==0) return true;
        if(sum==0) return true;
        if(n==0) return false;
        
        if(dp[n][sum]!=-1){
            return  dp[n][sum]==1 ?  true : false;
        }

        if(arr[n-1]<=sum){
             if((solveMem(n-1,arr,sum-arr[n-1],dp) || solveMem(n-1,arr,sum,dp))){
             dp[n][sum]=1;
             return true;
            }
             else{
                dp[n][sum]=0;
                return false;
             }
        }
        else{
        if(solveMem(n-1,arr,sum,dp)){
            dp[n][sum]=1;
            return true;
        }
        else{
            dp[n][sum]=0;
            return false;
        }
    }
    }
    static Boolean isSubsetSum(int n, int arr[], int sum){
        int dp[][] = new int[n+1][sum+1];

        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        
        return (solveMem(n,arr,sum,dp));
            
        // for(int i=0;i<n+1;i++){
        //     for(int j=0;j<sum+1;j++){
        //         if(i==0) dp[i][j]=false;
        //         if(j==0) dp[i][j]=true;
        //     }
        // }
        
        // for(int i=1;i<n+1;i++){
        //     for(int j=1;j<sum+1;j++){
                
        //     }
        // }
        
        // return solve(n,arr,sum);
    }
}