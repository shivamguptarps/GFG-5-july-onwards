//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static void printS(String s,int n,int o,int c,List<String> ans){
        if(o+c==2*n){
            ans.add(s);
            return;
        }
        if(o<n){
            printS(s+"(", n, o+1, c,ans);
        }
        if(o>c){
            printS(s+")", n, o, c+1,ans);
        }
    }
    public List<String> AllParenthesis(int n) 
    {
        List<String> ans= new ArrayList<>();
        printS("",n,0,0,ans);
        return ans;
    }
}