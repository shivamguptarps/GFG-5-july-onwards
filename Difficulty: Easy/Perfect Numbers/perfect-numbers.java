//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.isPerfectNumber(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int isPerfectNumber(long n) {
        if (n == 1) return 0;
        long ans=0;
        // int k=(int)Math.sqrt(n);
        for(long i=2;i*i<=n;i++){
            if(n%i==0) ans=ans+i+n/i;   
        }
        ans++;
        return n==ans?1:0;
    }
};