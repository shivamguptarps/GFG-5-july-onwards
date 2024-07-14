//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    private static int solveTabSO(int wt[],int val[],int W,int n){
        // int n = wt.length;

        int prev[]=new int[W+1];

        // if n==0 || w==0 initialization with 0 as already with zero so no need explicitly

        for(int i=1;i<n+1;i++){
            int curr[]=new int[W+1];
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    curr[j] = Math.max(val[i-1]+curr[j-wt[i-1]],prev[j]);
                }
                else{
                    curr[j] = prev[j];
                }
            }
            prev=curr;
        }
        return prev[W];
    }
    
    public int cutRod(int price[], int n) {
        int wt[]=new int[n];
        for(int i=1;i<=n;i++){
            wt[i-1]=i;
        }
        return solveTabSO(wt,price,n,n);
    }
}