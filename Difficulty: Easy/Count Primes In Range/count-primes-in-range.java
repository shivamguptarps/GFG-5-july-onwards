//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.countPrimes(L, R));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static void fillSieve(boolean sieve[]){
        int n=sieve.length-1;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!sieve[i])
                for(int j=i*2;j<=n;j+=i){
                    sieve[j]=true;
                }
        }
    }
    int countPrimes(int L, int n) {
        if(n==0 || n==1) return 0;
        boolean sieve[]=new boolean[n+1];
        sieve[0]=sieve[1]=true;
        fillSieve(sieve);
        
        int count=0;
        for(int i=L;i<=n;i++)
            if(!sieve[i]) count++;

        return count;
    }
};