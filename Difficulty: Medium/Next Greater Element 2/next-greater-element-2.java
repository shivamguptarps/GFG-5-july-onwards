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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int[] nextGreaterElement(int n, int arr[]) {
        Stack<Integer> st = new Stack<>();
        int idx=2*n-2;
        int ans[]=new int[n];
        for(int i=idx;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i%n]) st.pop();
            if(i<=n-1)
            ans[i]=!st.isEmpty() ? st.peek() : -1;
            
            st.push(arr[i%n]);
        }
        return ans;
    }
}
