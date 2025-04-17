//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private int helper(int num,int n,int m){
        long ans=1;
        for(int i=0;i<n;i++){
            ans*=num;
            if(ans>m) return 1;
        }
        return ans==m?0:-1;
    }
    public int nthRoot(int n, int m) {
        // code here
        int low=0,high=m;
        while(low<=high){
            int mid=low+(high-low)/2;

            int check = helper(mid,n,m);
            if(check==0) return mid;
            else if(check==1) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}