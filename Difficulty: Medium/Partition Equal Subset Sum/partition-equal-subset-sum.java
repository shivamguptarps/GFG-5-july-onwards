//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    
   
    static int equalPartition(int n, int arr[])
    {
         int sum =0;
        for(int t : arr) sum+=t;
        if(sum%2!=0) return 0;

        sum=sum/2;

        boolean prev[]=new boolean[sum+1];
        Arrays.fill(prev,false);
        prev[0]=true;
        
        
        for(int i=1;i<n+1;i++){
            for(int j=sum;j>=1;j--){
                if(arr[i-1]<=j){
                    prev[j]= prev[j-arr[i-1]] || prev[j];
                }
                else{
                    prev[j]=prev[j];
                }
            }
        }
        return prev[sum]==true ? 1 : 0;
    }
}