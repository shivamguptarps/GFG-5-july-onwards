//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static boolean[] sieve=new boolean[200000+1];
    static void sieve() {
        sieve[0]=sieve[1]=true;
        for(int i=2;i*i<=200000;i++){
            if(!sieve[i])
            for(int j=i*2;j<=200000;j+=i){
                sieve[j]=true;
            }
        }
    }

    static List<Integer> findPrimeFactors(int n) {
        List<Integer> arl = new ArrayList<>();
        
        for(int i=2;i<=n;i++){
            if(n%i==0 && !sieve[i]){
                while(n%i==0){
                    arl.add(i);
                    n/=i;
                }   
            }
        }
        return arl;
    }
}
