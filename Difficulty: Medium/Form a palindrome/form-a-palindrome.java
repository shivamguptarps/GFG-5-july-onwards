//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        int n=s.length();
        
        int prev[]=new int[n+1];
        
        for(int i=1;i<n+1;i++){
            int curr[]=new int[n+1];
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==(s.charAt((n-1)-(j-1)))){
             curr[j]= 1 + prev[j-1];
        }
        else{
            curr[j]= Math.max(prev[j],curr[j-1]);
        }
            }
            prev=curr;
        }

        return s.length()-prev[n];
    }
}