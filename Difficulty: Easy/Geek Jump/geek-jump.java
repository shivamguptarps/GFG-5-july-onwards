//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


class Solution{
        
   public int minimumEnergy(int arr[],int N){
        int dp[]=new int[N+1];
        dp[0]=dp[1]=0;
        for(int i=2;i<N+1;i++){
            int step1=0,step2=Integer.MAX_VALUE;
            step1=Math.abs(arr[i-1]-arr[i-2])+dp[i-1];
            if(i-3>=0){
                step2=Math.abs(arr[i-1]-arr[i-3])+dp[i-2];
            }
            dp[i]= Math.min(step1,step2);
        }
        return dp[N];
}
}