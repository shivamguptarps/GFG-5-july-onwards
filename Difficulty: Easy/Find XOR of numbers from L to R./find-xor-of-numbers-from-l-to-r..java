//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int l;
            l = sc.nextInt();

            int r;
            r = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.findXOR(l, r);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int solve(int temp){
        if(temp%4==0) return temp;
        else if(temp%4 ==1) return 1;
        else if(temp%4==2) return temp+1;
        else if(temp%4==3) return 0;
        
        return -1;
    }
    public static int findXOR(int l, int r) {
    //     000 0
    //     001 1
    //     010 3
    //     011 0
    //     100 4  %4 == 0 n
    //     101 1  %4 == 1 1
    //     110 7  %4 == 2 n+1
    //     111 0  %4 == 3 0
    //   1000
       
       return (solve(l-1)^(solve(r)));
       
       
    }
}