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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        int n=cardPoints.length;
        int ans=Integer.MIN_VALUE;
        int sum=0;
        for(int i=n-k;i<n;i++) sum+=cardPoints[i];
        ans=sum;
        int l=n-k;
        int r=n-1;
        while(r<n+k-1){
            sum-=cardPoints[l++];
            r++;
            sum+=cardPoints[r%n];
            ans=Math.max(sum,ans);
        }
        return ans;
    }
}
